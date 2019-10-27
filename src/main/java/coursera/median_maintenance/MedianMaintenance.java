package coursera.median_maintenance;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <p>Median-Maintenance keeps track of the median of a growing list of numbers.</p>
 * Complexity:
 * <ul>
 * <li>add(int x) =&gt; O(log(n)), n is the number of elements so far</li>
 * <li>getMedian() =&gt; O(1)</li>
 * <li>adding n elements to this data structure and return the median after each add-Operation: O(n*log(n))</li>
 * </ul>
 */
public class MedianMaintenance<T extends Number & Comparable<T>> {
	private PriorityQueue<T> smallHalf;
	private PriorityQueue<T> largeHalf;

	public MedianMaintenance() {
		smallHalf = new PriorityQueue<T>(Collections.reverseOrder());
		largeHalf = new PriorityQueue<T>();
	}
	
	/**
	 * @param  size  optional - initial size of the MedianMaintenance data structure
	 */
	public MedianMaintenance(int size) {
		smallHalf = new PriorityQueue<T>(size, Collections.reverseOrder());
		largeHalf = new PriorityQueue<T>(size);
	}

	/**
	 * returns the current median
	 * @return  the current median
	 * @throws Exception if the sub-data structures are unbalanced for some reason
	 */
	public T getMedian() throws Exception {
		if (smallHalf.size() == largeHalf.size() || smallHalf.size() - 1 == largeHalf.size()) {
			return smallHalf.peek();
		} else if (smallHalf.size() == largeHalf.size() - 1) {
			return largeHalf.peek();
		} else {
			throw new Exception("There is an error in the over-heap-balancing");
		}
	}

	/**
	 * adds a number to the MedianMaintenance data structure
	 * @param  n  a number you want to add to the MedianMaintenance data structure
	 */
	public void add(T n) {
		if (smallHalf.size() == 0 && largeHalf.size() == 0) {
			largeHalf.add(n);
			return;
		}
		if (smallHalf.size() == 0 && largeHalf.size() > 0) {
			if (largeHalf.peek().compareTo(n) >= 0) {
				smallHalf.add(n);
			} else {
				smallHalf.add(largeHalf.poll());
				largeHalf.add(n);
			}
			return;
		}
		T x = smallHalf.peek();
		T y = largeHalf.peek();
		if (n.compareTo(x) <= 0) {
			// needs to be inserted into the smallHalf
			if (smallHalf.size() > largeHalf.size()) {
				largeHalf.add(smallHalf.poll());
			}
			smallHalf.add(n);
		} else if (n.compareTo(y) >= 0) {
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

	/**
	 * adds a number to the MedianMaintenance data structure and returns the current median after that
	 * @param  n  a number you want to add to the MedianMaintenance data structure
	 * @return  the current median
	 * @throws Exception if the sub-data structures are unbalanced for some reason
	 */
	public T addAndReturnMedian(T n) throws Exception {
		add(n);
		return getMedian();
	}
}
