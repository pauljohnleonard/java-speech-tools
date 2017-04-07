package speech.spectral;

import java.util.ArrayList;
import java.util.Arrays;

import speech.Data;

public class MelSpectrumToFeature implements DataProcess {

	double[] magnLog;

	private int featureSize;
	private int fftSize;

	ArrayList<Weight>[] weights;

	private float fLow;

	private float fHigh;

	public MelSpectrumToFeature(int featureSize, int fftSize, float fLow,
			float fHigh, float Fs) {

		this.fLow = fLow;
		this.fHigh = fHigh;
		this.featureSize = featureSize;

		float mLow = fToMel(fLow);
		float mHigh = fToMel(fHigh);

		float featMelFreq[] = new float[featureSize + 1];

		for (int i = 0; i < featureSize + 1; i++) {
			featMelFreq[i] = mLow + i * (mHigh - mLow) / (this.featureSize - 1);
		}

		int nFreq = fftSize / 2;

		weights = new ArrayList[featureSize];

		for (int i = 0; i < featureSize; i++) {
			weights[i] = new ArrayList<Weight>();
		}

		float fBin = Fs / fftSize;

		float spectMelFreq[] = new float[nFreq];

		for (int i = 0; i < nFreq; i++) {
			spectMelFreq[i] = fToMel(i * fBin);
		}

		float f0 = 0.0f;

		for (int i = 0; i < featureSize; i++) {
			float f1 = featMelFreq[i];
			float f2 = featMelFreq[i + 1];
			for (int bin = 0; bin < nFreq; bin++) {
				float f = spectMelFreq[bin];
				if (f > f0) {
					if (f < f1) {
						float w = (f - f0) / (f1 - f0);
						addWeight(i, bin, w);
					} else if (f < f2) {
						float w = (f2 - f) / (f2 - f1);
						addWeight(i, bin, w);
					}
				}
			}
			f0 = f1;
		}

		magnLog = new double[featureSize];
		this.featureSize = featureSize;
		this.fftSize = fftSize;

		scale();
	}

	void scale() {

		double sc[] = new double[featureSize];

		for (int i = 0; i < featureSize; i++) {

			System.out.println(" Feature: " + i);
			for (Weight w : weights[i]) {
				System.out.println(w.j + " " + w.w);
				sc[i] += w.w;
			}
		}
		for (int i = 0; i < featureSize; i++) {

			System.out.println(" Feature: " + i);
			for (Weight w : weights[i]) {
				System.out.println(w.j + " " + w.w);
				w.w = w.w / sc[i];
			}
		}

	}

	private void addWeight(int i, int bin, float w) {
		weights[i].add(new Weight(bin, w));

	}

	public float fToMel(float f) {
		return (float) (2595.0 * Math.log10(1.0 + f / 700.0));
	}

	@Override
	public void process(Data data) {
		double[] spectrum = data.spectrum;
		double[] feature = data.feature;

		assert (spectrum.length == fftSize / 2);
		assert (feature.length == featureSize);
		Arrays.fill(feature, 0.0);

		for (int i = 0; i < featureSize; i++) {
			for (Weight w : weights[i]) {
				feature[i] += w.w * spectrum[w.j];
			}
		}

	}

	public String getName() {
		return "MEL" + "_" + fftSize + "_" + featureSize + "_" + fLow + "_"
				+ fHigh;
	}

	class Weight {
		public Weight(int i, float w2) {
			j = i;
			w = w2;
		}

		int j;
		double w;
	};
}
