## Median-Maintenance

Median-Maintenance keeps track of the median of a growing list of numbers.

### Complexity

* add(int x) => O(log(n)), n is the number of elements so far
* getMedian() => O(1)
* adding n elements to this data structure and return the median after each add-Operation: O(n*log(n))

### Examples

```java
MedianMaintenance<Integer> mm = new MedianMaintenance<Integer>(3);
mm.add(4);
mm.getMedian(); // returns 4
mm.add(10);
mm.getMedian(); // returns 4
mm.add(20);
mm.getMedian(); // returns 10
```

```java
MedianMaintenance<Integer> mm = new MedianMaintenance<Integer>(6);
mm.add(0);
mm.getMedian(); // returns 0
mm.add(1);
mm.getMedian(); // returns 0
mm.add(2);
mm.getMedian(); // returns 1
mm.add(3);
mm.getMedian(); // returns 1
mm.add(4);
mm.getMedian(); // returns 2
mm.add(5);
mm.getMedian(); // returns 2
```

```java
MedianMaintenance<Integer> mm = new MedianMaintenance<Integer>(6);
mm.addAndReturnMedian(4); // returns 4
mm.addAndReturnMedian(7); // returns 4
mm.addAndReturnMedian(1); // returns 4
mm.addAndReturnMedian(3); // returns 3
mm.addAndReturnMedian(10); // returns 4
mm.addAndReturnMedian(12); // returns 4
```

```java
MedianMaintenance<Double> mm = new MedianMaintenance<Double>();
mm.addAndReturnMedian(-1.1); // returns -1.1
mm.addAndReturnMedian(9.1); // returns -1.1
mm.addAndReturnMedian(-2.7); // returns -1.1
mm.addAndReturnMedian(-8.1); // returns -2.7
mm.addAndReturnMedian(-7); // returns -2.7
mm.addAndReturnMedian(6.6); // returns -2.7
mm.addAndReturnMedian(6.8); // returns -1.1
```
