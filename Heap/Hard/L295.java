package Heap.Hard;

// 295. Find Median from Data Stream

import java.util.Collections;
import java.util.PriorityQueue;

public class L295 {
    static PriorityQueue<Integer> minPQ;
    static PriorityQueue<Integer> maxPQ;

    public L295() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }
    public void addNum(int num) {
        minPQ.add(num);
        maxPQ.add(minPQ.poll());
        if(minPQ.size() < maxPQ.size())
            minPQ.add(maxPQ.poll());
    }

    public double findMedian() {
        if(minPQ.size() == 0)
            return 0;
        return minPQ.size() > maxPQ.size() ? minPQ.peek() : (double)(maxPQ.peek()+ minPQ.peek())/2;
    }

    public static void main(String[] args) {
        L295 medianFinder = new L295();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(N)