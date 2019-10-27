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

}
