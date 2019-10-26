package coursera.median_maintenance;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianMaintenance {
	private PriorityQueue<Integer> smallHalf;
	private PriorityQueue<Integer> largeHalf;
	
	public MedianMaintenance(int size) {
		smallHalf = new PriorityQueue<Integer>(size, Collections.reverseOrder());
		largeHalf = new PriorityQueue<Integer>(size);
	}
}
