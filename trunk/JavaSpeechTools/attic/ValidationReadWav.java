package speech.monopthong;

import com.frinika.audio.io.AudioReader;
import com.frinika.audio.io.VanillaRandomAccessFile;

import config.Config;

import java.io.File;
import java.io.RandomAccessFile;

import speech.spectral.SampledToSpectral;
import uk.org.toot.audio.core.AudioBuffer;

//
//@author JER
//
/*
 * 
 * Reads a wav file from disk, performs a FFT on it, and stores the information
 * in an array
 *  
 */

// (MainApp now reads in wave)
@Deprecated   
public class ValidationReadWav {

	public static int file_length[];
	public static int file_length_patient;
	public static int test;

	public ValidationReadWav(int outputs, int test) {
		file_length = new int[outputs + 1];
		this.test = test;
	}

	public static double[][][] getMonoThongWavs(int fftSize, int outputs,
			float Fs, int maxAudioLength) throws Exception {

		double allWavs[][][] = new double[maxAudioLength][fftSize][7];

		String names[] = { "_training_eee", "_training_ehh",
				"_training_err", "_training_ahh", "_training_ooh", "_training_uhh",
				"training_silence" };

		for (int i = 0; i < outputs + 1; i++) {
			
			if(i != outputs) {
				names[i] = test + "" +names[i];
			}

			String resource = "src/speech/validationwavs/" + names[i] + ".wav";
			double wav[][] = readWav(resource, fftSize, Fs, i);

			for (int j = 0; j < wav.length; j++) {
				for (int k = 0; k < wav[0].length; k++) {
					allWavs[j][k][i] = wav[j][k];
				}
			}
		}

		return allWavs;

	}
	
	public static double[][][] getTestWavs(int fftSize, int outputs,
			float Fs, int maxAudioLength) throws Exception {

		double allWavs[][][] = new double[maxAudioLength][fftSize][21];

		String names[] = { "_testing_eee", "_testing_ehh",
				"_testing_err", "_testing_ahh", "_testing_ooh", "_testing_uhh",
				"testing_silence" };

		for (int i = 0; i < outputs + 1; i++) {
			
			if(i != outputs) {
				names[i] = test + "" +names[i];
			}

			String resource = "src/speech/validationwavs/" + names[i] + ".wav";
			double wav[][] = readWav(resource, fftSize, Fs, i);

			for (int j = 0; j < wav.length; j++) {
				for (int k = 0; k < wav[0].length; k++) {
					allWavs[j][k][i] = wav[j][k];
				}
			}
		}

		return allWavs;

	}
	
	public static double[][] getPatientWavs(int fftSize, int outputs,
			float Fs, int maxAudioLength) throws Exception {

		String resource = "/bunty/pjl/Dropbox/SpeechShare/SORTED/Anny/Father.wav" ;
				// "//src/speech/validationwavs/patients/male patient e vowel.wav";
		double wav[][] = readWav(resource, fftSize, Fs, 0);
		return wav;

	}
	
	

	public static double[][] readWav(String filename, int fftSize, float Fs,
			int num) throws Exception {

		SampledToSpectral spectralAnalysis = new SampledToSpectral(
				fftSize,0, Fs,Config.getFeatureVectorSize());
		File file = new File(filename);
		RandomAccessFile rafG = new RandomAccessFile(file, "r");
		AudioReader audioReader = new AudioReader(new VanillaRandomAccessFile(
				rafG),Config.sampleRate);
		AudioBuffer chunk = new AudioBuffer("James buffer", 2, fftSize, Fs);
		chunk.setRealTime(true);

		double[][] output = new double[1000][fftSize];

		int i = 0;

		while (!audioReader.eof()) {

			chunk.makeSilence();
			audioReader.processAudio(chunk);
			spectralAnalysis.processAudio(chunk,null);
			// FIXME (maybe) double output_buffer[] = spectralAnalysis.getMagn();
//			for (int j = 0; j < output_buffer.length; j++) {
//				output[i][j] = output_buffer[j];
//			}
//			i++;

		}

		file_length_patient = i;
		System.out.println("The file has a length of: " + file_length_patient);

		return output;

	}

}
