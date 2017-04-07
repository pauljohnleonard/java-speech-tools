package speech.spectral;

import java.io.IOException;


import java.util.List;

import uk.org.toot.audio.core.AudioBuffer;
import uk.org.toot.audio.core.AudioProcess;
import uk.org.toot.audio.server.AudioClient;
import uk.org.toot.audio.server.IOAudioProcess;
import uk.org.toot.audio.server.JavaSoundAudioServer;

import com.frinika.audio.io.AudioReader;
import com.frinika.audio.io.AudioWriter;

import config.Config;

/***
 * 
 * @author pjl
 *
 *  Real time audio source.
 *     reads from the input or you can stream a file.
 *     feeds raw data in chunks to a user supplied AudioClient.
 *     
 *     usage 
 *     
 *===================================     
 		realTimeSource = new TootRealTimeAudioSource();
 
 /* Start the engine using default input.
 		realTimeSource.startAudio(client);
 
 /*  Replace input using a AudioReader source.
 /* (returns to default after end of file)
       realTimeSpectralSource.streamFile(audioReader);
 
 */

public class TootRealTimeAudioSource implements RealTimeAudioSource{

	private  JavaSoundAudioServer audioServer;
	private  AudioBuffer chunk;
	private  AudioClient audioClient;
	
	private AudioReader reader;

	private boolean eof=false;
	private AudioWriter recorder;
	
	//public static SpectralClient client;
	public static double spectrum[];

	public TootRealTimeAudioSource() {
		
		
	}

	public void startAudio(final AudioProcess client)
			throws Exception {

		// Setup audio server
		String ins[]=Config.preferredIn;
		String outs[]=Config.preferredOut;
		
		audioServer = new JavaSoundAudioServer();
		
		// ----------- INPUT  SELECT
		List<String> inputs = audioServer.getAvailableInputNames();
		System.out.println("Available Inputs:");
		for (String name : inputs) {
			System.out.println(name);
		}
		
		String inName=null;

		for (String ins1:ins){
			for (String name : inputs) {
				if (name.startsWith(ins1)){
					inName=name;
					break;
				}
			}
			if (inName != null) break;
		}

		if (inName == null) inName=inputs.get(0);

		
		/// -------- OUTPUTS 
		String outName=null;
		
		List<String> outputs = audioServer.getAvailableOutputNames();
		System.out.println("Available Outputs:");
		
		for (String name : outputs) {
			System.out.println(name);
		}


		for (String outs1:outs){
			for (String name : outputs) {

				if (name.startsWith(outs1)){
					outName=name;
					break;
				}
			}
			if (outName != null) break;
		}

		if (outName == null) outName=outputs.get(0);
		
		//---------------
		
		System.out.println(" Using Output: " + outName);
		System.out.println("  Using Input: " + inName);

		final IOAudioProcess output = audioServer.openAudioOutput(outName,"output");
		final IOAudioProcess input = audioServer
				.openAudioInput(inName, "input");
//
//		final AudioBuffer zero = audioServer.createAudioBuffer("zero");
//		zero.setRealTime(true);
	
		chunk = audioServer.createAudioBuffer("default");
		chunk.setRealTime(true);
		
		
		final AudioBuffer chunkOut = audioServer.createAudioBuffer("default");
		chunkOut.setRealTime(true);
		chunkOut.makeSilence();
		
		audioClient = new AudioClient() {
			
			public void work(int arg0) {
				chunk.makeSilence();
				if (reader != null) {
					reader.processAudio(chunk);
					
					if (!eof) {
						if (reader.eof()) {
							eof=true;
						}
					}
				} else {
					input.processAudio(chunk);
				}
				
				
				try {
					client.processAudio(chunk);
					
					if (reader != null) {
						output.processAudio(chunk);
					} else {
						output.processAudio(chunkOut);
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public void setEnabled(boolean arg0) {
			}
		};

		audioServer.setClient(audioClient);
		audioServer.start();

		// shutdown hook to close the audio devices.
		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {

				System.out.println("Stop...");
				audioServer.stop();

			}
		});
	}

	public void record(AudioWriter recorder){
		this.recorder=recorder;
	}
	
	public void streamFile(AudioReader audioReader) {
		reader=audioReader;
		eof=false;
		if (reader == null) return;
		
		try {
			reader.seekFrame(0, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * returns true if streaming from file and we are at the end. 
	 */
	public boolean isEOF() {
		
		return eof;
	}

}