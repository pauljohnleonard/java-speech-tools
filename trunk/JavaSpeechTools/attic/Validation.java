package speech.monopthong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.Timer;

import config.Config;

import speech.NeuralNet;
import speech.spectral.SpectrumToFeature;

public class Validation {

	public static int onscreenBins = Config.getFeatureVectorSize();
	public static int fftSize = Config.getFFTSize();
	public static int phonemes = Config.getNumberOfTargets();   // TODO
	public static float Fs = Config.sampleRate;
	public static int maxAudioLength = 1000;

	public static double spectrum[] = new double[fftSize];
	public double outputSort[] = new double[phonemes];
//	public static double magnLog[];
	public static double smoothed[];
	public static double outputs[];

	static ValidationReadWav readTestWav;
	static NeuralNet neuralNet;
	static SpectrumToFeature specAdj;

	public boolean isApplet = false; // hack hack hack ... eeeek

	public static void main(String args[]) throws Exception {

		FileInputStream ostr;
		try {
			ostr = new FileInputStream("src/textfiles/network.txt");
			ObjectInputStream in = new ObjectInputStream(ostr);
			neuralNet = (NeuralNet) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		readTestWav = new ValidationReadWav(phonemes, 11);
		specAdj = new SpectrumToFeature(onscreenBins,fftSize);
		double testWav[][][] = readTestWav.getTestWavs(fftSize, phonemes, Fs,
				maxAudioLength);

		DecimalFormat df = new DecimalFormat("#.0###");

		for (int i = 0; i < phonemes + 1; i++) {
			for (int k = 0; k < 22; k++) {
				for (int j = 0; j < fftSize; j++) {
					spectrum[j] = testWav[k][j][i];
				}

			//	magnLog = specAdj.linearLog(onscreenBins, fftSize, spectrum);
				specAdj.spectrumToFeature(spectrum,smoothed);  //specAdj.running3Average(onscreenBins, magnLog);
				outputs = neuralNet.forwardPass(smoothed);

				System.out.println(
						df.format(outputs[0]) + " " + 
						df.format(outputs[1]) + " " + 
						df.format(outputs[2]) + " " + 
						df.format(outputs[3]) + " " + 
						df.format(outputs[4]) + " " + 
						df.format(outputs[5]));
			}
		}

	}
}