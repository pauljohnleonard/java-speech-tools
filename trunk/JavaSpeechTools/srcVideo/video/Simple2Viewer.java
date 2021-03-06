package video;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import au.edu.jcu.v4l4j.FrameGrabber;
import au.edu.jcu.v4l4j.CaptureCallback;
import au.edu.jcu.v4l4j.V4L4JConstants;
import au.edu.jcu.v4l4j.VideoDevice;
import au.edu.jcu.v4l4j.VideoFrame;
import au.edu.jcu.v4l4j.exceptions.StateException;
import au.edu.jcu.v4l4j.exceptions.V4L4JException;

/**
 * This class demonstrates how to perform a simple push-mode capture. It starts
 * the capture and display the video stream in a JLabel
 * 
 * @author gilles
 * 
 */
public class Simple2Viewer extends WindowAdapter {
	private static int width = 640, height = 480,
			std = V4L4JConstants.STANDARD_WEBCAM, channel = 0;
	private static String[] device = { "/dev/video0" , "/dev/video1" };

	private VideoDevice[] videoDevice;
	private FrameGrabber[] frameGrabber;

	private JLabel label[];
	private JFrame frame;

	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Simple2Viewer();
			}
		});
	}

	/**
	 * Builds a WebcamViewer object
	 * 
	 * @throws V4L4JException
	 *             if any parameter if invalid
	 */
	public Simple2Viewer() {
		// Initialise video device and frame grabber
		try {
			initFrameGrabber();
		} catch (V4L4JException e1) {
			System.err.println("Error setting up capture");
			e1.printStackTrace();

			// cleanup and exit
			cleanupCapture();
			return;
		}

		// create and initialise UI
		initGUI();

		// start capture
		try {

			for (FrameGrabber f : frameGrabber) {
				System.out.println(" starting capture on "+f);
				f.startCapture();
			}
		} catch (V4L4JException e) {
			System.err.println("Error starting the capture");
			e.printStackTrace();
		}
	}

	/**
	 * Initialises the FrameGrabber object
	 * 
	 * @throws V4L4JException
	 *             if any parameter if invalid
	 */
	private void initFrameGrabber() throws V4L4JException {
		frameGrabber = new FrameGrabber[device.length];
		videoDevice = new VideoDevice[device.length];
		for (int i = 0; i < device.length; i++) {
			final int iFrame=i;
			videoDevice[i] = new VideoDevice(device[i]);
			frameGrabber[i] = videoDevice[i].getJPEGFrameGrabber(width, height,
					channel, std, 80);
			
			CaptureCallback cb=new CaptureCallback() {
				@Override
				public void exceptionReceived(V4L4JException e) {
					// This method is called by v4l4j if an exception
					// occurs while waiting for a new frame to be ready.
					// The exception is available through e.getCause()
					e.printStackTrace();
				}	

				@Override
				public void nextFrame(VideoFrame frame) {
					// This method is called when a new frame is ready.
					// Don't forget to recycle it when done dealing with the frame.

					// draw the new frame onto the JLabel
					label[iFrame].getGraphics().drawImage(frame.getBufferedImage(), 0, 0, width,
							height, null);

					// recycle the frame
					frame.recycle();
				}
			
			
			};
			
			frameGrabber[i].setCaptureCallback(cb);
			assert (width == frameGrabber[i].getWidth());
			assert (height == frameGrabber[i].getHeight());
			System.out.println("Starting capture "+i+" at "+width+"x"+height);
		}
	}

	/**
	 * Creates the UI components and initialises them
	 */
	private void initGUI() {
		frame = new JFrame();
		label = new JLabel[device.length];
		for (int i = 0; i < device.length; i++) {
			label[i] = new JLabel();
			frame.getContentPane().add(label[i]);
		}
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(this);
		frame.setVisible(true);
		frame.setSize(width*2, height);
	}

	/**
	 * this method stops the capture and releases the frame grabber and video
	 * device
	 */
	private void cleanupCapture() {
		try {

			for (int i=0;i<device.length;i++) {
				frameGrabber[i].stopCapture();

				// release the frame grabber and video device
				videoDevice[i].releaseFrameGrabber();
				videoDevice[i].release();

			}
		} catch (StateException ex) {
			// the frame grabber may be already stopped, so we just ignore
			// any exception and simply continue.
		}
	}

	/**
	 * Catch window closing event so we can free up resources before exiting
	 * 
	 * @param e
	 */
	public void windowClosing(WindowEvent e) {
		cleanupCapture();

		// close window
		frame.dispose();
	}


}