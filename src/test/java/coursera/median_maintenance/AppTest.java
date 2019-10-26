package coursera.median_maintenance;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test1() throws Exception {
		MedianMaintenance mm = new MedianMaintenance(3);
		assertEquals(mm.addAndReturnMedian(4), 4);
		assertEquals(mm.addAndReturnMedian(10), 4);
		assertEquals(mm.addAndReturnMedian(20), 10);
	}
	
	@Test
	public void test2() throws Exception {
		MedianMaintenance mm = new MedianMaintenance(10);
		assertEquals(mm.addAndReturnMedian(0), 0);
		assertEquals(mm.addAndReturnMedian(1), 0);
		assertEquals(mm.addAndReturnMedian(2), 1);
		assertEquals(mm.addAndReturnMedian(3), 1);
		assertEquals(mm.addAndReturnMedian(4), 2);
		assertEquals(mm.addAndReturnMedian(5), 2);
	}
	
	@Test
	public void test3() throws Exception {
		MedianMaintenance mm = new MedianMaintenance(10);
		mm.addAndReturnMedian(4);
		mm.addAndReturnMedian(7);
		mm.addAndReturnMedian(1);
		mm.addAndReturnMedian(10);
		mm.addAndReturnMedian(3);
		assertEquals(mm.addAndReturnMedian(12), 4);
	}

}
