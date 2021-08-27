package LCNQ;

import java.util.PriorityQueue;

public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if(big.size() >= small.size()) {
            big.add(num);
            small.add(big.poll());
        } else {
            small.add(num);
            big.add(small.poll());
        }
    }

    public double findMedian() {
        if(big.size() > small.size()) return big.peek();
        if(big.size() == small.size()) return (big.peek() + small.peek()) / 2.0;
        return small.peek();
    }
}
