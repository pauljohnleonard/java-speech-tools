package speech;

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
 * Reads a wav file from disk, performs a FFT on it, 
 * and return the information in an array
 *  
 */

public class ReadWav {

	public int file_length[];
	private Config config;
	private String srcDir;

	public ReadWav(String srcDir,int outputs) {
		file_length = new int[outputs + 1];
		this.srcDir=srcDir;
	}

	public double[][][] getMonoThongWavs(Config config, int maxAudioLength) throws Exception {
		this.config=config;
		
		double allWavs[][][] = new double[maxAudioLength][config.getFFTSize()][21];
//
//		String names[] = { "eee_all", "ehh_all", "err_all", "ahh_all",
//				"ooh_all", "uhh_all", "silence_all" };

		String cn[]=config.getOutputNames();
		
		String files[] = new String[cn.length+1];
		
		for (int i=0;i<cn.length;i++) {
			files[i]=srcDir+"/"+cn[i].toLowerCase()+"_all.wav";
		}
		
		files[cn.length]=srcDir+"/silence_all.wav";
		
		for (int i = 0; i < config.getOutputSize() + 1; i++) {

			//String resource = "src/speech/wavfiles/" + names[i] + ".wav";
			//assert(resource.equals(files[i]));
			double wav[][] = readWav(files[i], config.getFFTSize(),config.getSampleRate(), i);

			for (int j = 0; j < wav.length; j++) {
				for (int k = 0; k < wav[0].length; k++) {
					allWavs[j][k][i] = wav[j][k];
				}
			}
		}

		return allWavs;

	}

	public double[][] readWav(String filename, int fftSize, float Fs,
			int num) throws Exception {

		SampledToSpectral spectralAnalysis = new SampledToSpectral(
				fftSize, 0,config.getSampleRate(),config.getFeatureVectorSize());
		File file = new File(filename);
		RandomAccessFile rafG = new RandomAccessFile(file, "r");
		AudioReader audioReader = new AudioReader(new VanillaRandomAccessFile(
				rafG),Fs);
		AudioBuffer chunk = new AudioBuffer("James buffer", 2, fftSize, Fs);
		chunk.setRealTime(true);

		double[][] output = new double[1000][fftSize/2];

		int i = 0;

	
		while (!audioReader.eof()) {

			chunk.makeSilence();
			audioReader.processAudio(chunk);
			
			double magn[]=spectralAnalysis.processAudio2(chunk);
			
			for (int j = 0; j < magn.length; j++) {
				output[i][j] = magn[j];
			}
			i++;

		}

		file_length[num] = i;
		System.out.println("The file has a length of: " + i);

		return output;

	}

}
