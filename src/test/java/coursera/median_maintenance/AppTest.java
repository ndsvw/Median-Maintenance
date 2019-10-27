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

	@Test
	public void testByte() throws Exception {
		byte[] arr = new byte[] { 'a', 'c', 'd', 'z', 'x' };
		byte[] medians = new byte[] { 'a', 'a', 'c', 'c', 'd' };
		MedianMaintenance<Byte> mm = new MedianMaintenance<Byte>(arr.length);
		for (int i = 0; i < 5; i++) {
			assertEquals((byte) mm.addAndReturnMedian(arr[i]), medians[i]);
		}
	}

	@Test
	public void testBigInteger() throws Exception {
		BigInteger[] arr = new BigInteger[] { BigInteger.ONE, BigInteger.ZERO, new BigInteger("12345678901234567890"),
				new BigInteger("99999999909999999990"), new BigInteger("10").pow(100) };
		BigInteger[] medians = new BigInteger[] { BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE,
				new BigInteger("12345678901234567890"), new BigInteger("12345678901234567890") };
		MedianMaintenance<BigInteger> mm = new MedianMaintenance<BigInteger>(arr.length);
		for (int i = 0; i < 5; i++) {
			assertEquals((BigInteger) mm.addAndReturnMedian(arr[i]), medians[i]);
		}
	}

}
