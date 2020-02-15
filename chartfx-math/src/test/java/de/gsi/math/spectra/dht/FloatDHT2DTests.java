package de.gsi.math.spectra.dht;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.jtransforms.dht.FloatDHT_2D;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 *
 * @author rstein
 */
public class FloatDHT2DTests {
    public static final float FFT_NUMERIC_LIMITS = 1e-3f;

    @ParameterizedTest
    @CsvSource({ "2,2", "2,4", "4,2", "4,4", "4,8", "8,4", "6,6", "1024,1024", "1024,512", "512, 1024", "511, 1023", "65536,2" })
    public void basicReal2dIdentityTests(final int nRows, final int nCols) {
        FloatDHT_2D fft = new FloatDHT_2D(nRows, nCols);

        final int nSamples = nRows * nCols;
        float[][] testSignal1Ref = generateDelta(nRows, nCols);
        float[][] testSignal1 = generateDelta(nRows, nCols);

        // basic identity tests
        fft.forward(testSignal1);
        fft.inverse(testSignal1, true);
        for (int i = 0; i < nRows; i++) {
            assertArrayEquals(testSignal1Ref[i], testSignal1[i], nSamples * FFT_NUMERIC_LIMITS, "delta identity " + i);
        }

    }

    @ParameterizedTest
    @CsvSource({ "2,2", "2,4", "4,2", "4,4", "4,8", "8,4", "6,6", "1024,1024", "1024,512", "512, 1024", "511, 1023", "65536,2" })
    public void basicRealIdentityTests(final int nRows, final int nCols) {
        FloatDHT_2D fft = new FloatDHT_2D(nRows, nCols);

        final int nSamples = nRows * nCols;
        float[] testSignal1Ref = generateDelta(nSamples);
        float[] testSignal1 = generateDelta(nSamples);
        float[] testSignal2Ref = generateRamp(nSamples, nSamples);
        float[] testSignal2 = generateRamp(nSamples, nSamples);

        // basic identity tests
        fft.forward(testSignal1);
        fft.inverse(testSignal1, true);
        assertArrayEquals(testSignal1Ref, testSignal1, nSamples * FFT_NUMERIC_LIMITS, "delta identity");

        fft.forward(testSignal2);
        fft.inverse(testSignal2, true);
        assertArrayEquals(testSignal2Ref, testSignal2, nSamples * FFT_NUMERIC_LIMITS, "ramp identity");

    }

    private static float[] generateDelta(final int nSamples) {
        final float[] retVal = new float[nSamples];
        retVal[0] = 1.0f;
        return retVal;
    }

    private static float[][] generateDelta(final int nRows, final int nCols) {
        final float[][] retVal = new float[nRows][];
        for (int i = 0; i < nRows; i++) {
            retVal[i] = new float[nCols];
        }
        retVal[0][0] = 1.0f;
        return retVal;
    }

    private static float[] generateRamp(final int nSamples, final int nRamp) {
        final float[] retVal = new float[nSamples];
        for (int i = 0; i < nRamp; i++) {
            retVal[i] = i;
        }
        return retVal;
    }

}