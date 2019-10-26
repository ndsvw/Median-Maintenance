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
	
	public int getMedian() throws Exception {
		if (smallHalf.size() == largeHalf.size() || smallHalf.size() - 1 == largeHalf.size()) {
			return smallHalf.peek();
		} else if (smallHalf.size() == largeHalf.size() - 1) {
			return largeHalf.peek();
		} else {
			throw new Exception("There is an error in the over-heap-balancing");
		}
	}

	public void add(int n) {
		if (smallHalf.size() == 0 && largeHalf.size() == 0) {
			largeHalf.add(n);
			return;
		}
		if (smallHalf.size() == 0 && largeHalf.size() > 0) {
			if (largeHalf.peek() >= n) {
				smallHalf.add(n);
			} else {
				smallHalf.add(largeHalf.poll());
				largeHalf.add(n);
			}
			return;
		}
		int x = smallHalf.peek();
		int y = largeHalf.peek();
		if (n <= x) {
			// needs to be inserted into the smallHalf
			if (smallHalf.size() > largeHalf.size()) {
				largeHalf.add(smallHalf.poll());
			}
			smallHalf.add(n);
		} else if (n >= y) {
			// needs to be inserted into the largeHalf
			if (largeHalf.size() > smallHalf.size()) {
				smallHalf.add(largeHalf.poll());
			}
			largeHalf.add(n);
		} else {
			// we put it in the PrioQueue with smaller size
			if (smallHalf.size() <= largeHalf.size()) {
				smallHalf.add(n);
			} else {
				largeHalf.add(n);
			}
		}
	}

	public int addAndReturnMedian(int n) throws Exception {
		add(n);
		return getMedian();
	}
}
