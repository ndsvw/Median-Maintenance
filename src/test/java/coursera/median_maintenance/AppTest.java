package coursera.median_maintenance;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class AppTest {

	@Test
	public void testInt1() throws Exception {
		MedianMaintenance<Integer> mm = new MedianMaintenance<Integer>(3);
		assertEquals((int) mm.addAndReturnMedian(4), 4);
		assertEquals((int) mm.addAndReturnMedian(10), 4);
		assertEquals((int) mm.addAndReturnMedian(20), 10);
	}

	@Test
	public void testInt2() throws Exception {
		MedianMaintenance<Integer> mm = new MedianMaintenance<Integer>(10);
		assertEquals((int) mm.addAndReturnMedian(0), 0);
		assertEquals((int) mm.addAndReturnMedian(1), 0);
		assertEquals((int) mm.addAndReturnMedian(2), 1);
		assertEquals((int) mm.addAndReturnMedian(3), 1);
		assertEquals((int) mm.addAndReturnMedian(4), 2);
		assertEquals((int) mm.addAndReturnMedian(5), 2);
	}

	@Test
	public void testInt3() throws Exception {
		MedianMaintenance<Integer> mm = new MedianMaintenance<Integer>(10);
		mm.addAndReturnMedian(4);
		mm.addAndReturnMedian(7);
		mm.addAndReturnMedian(1);
		mm.addAndReturnMedian(10);
		mm.addAndReturnMedian(3);
		assertEquals((int) mm.addAndReturnMedian(12), 4);
	}

	@Test
	public void testLong() throws Exception {
		long[] arr = new long[] { 4, 7, 1, 3, 10, 12 };
		long[] medians = new long[] { 4, 4, 4, 3, 4, 4 };
		MedianMaintenance<Long> mm = new MedianMaintenance<Long>(arr.length);
		for (int i = 0; i < 6; i++) {
			assertEquals((long) mm.addAndReturnMedian(arr[i]), medians[i]);
		}
	}

	@Test
	public void testDouble() throws Exception {
		double[] arr = new double[] { -1.1, 9.1, -2.7, -8.1, -7, 6.6, 6.8 };
		double[] medians = new double[] { -1.1, -1.1, -1.1, -2.7, -2.7, -2.7, -1.1 };
		MedianMaintenance<Double> mm = new MedianMaintenance<Double>(arr.length);
		for (int i = 0; i < 7; i++) {
			assertEquals((double) mm.addAndReturnMedian(arr[i]), medians[i], 0.01);
		}
	}

	@Test
	public void testFloat() throws Exception {
		float[] arr = new float[] { -1.1f, 9.1f, -2.7f, -8.1f, -7f, 6.6f, 6.8f };
		float[] medians = new float[] { -1.1f, -1.1f, -1.1f, -2.7f, -2.7f, -2.7f, -1.1f };
		MedianMaintenance<Float> mm = new MedianMaintenance<Float>(arr.length);
		for (int i = 0; i < 7; i++) {
			assertEquals((float) mm.addAndReturnMedian(arr[i]), medians[i], 0.01);
		}
	}

}
