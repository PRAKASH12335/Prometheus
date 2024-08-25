package TwoPointer.Hard;

// Moving Average from Data Stream

import java.util.*;

public class L346 {

    // Using array
//    int size;
//    List<Integer> q = new ArrayList<>();
//
//    public L346(int size) {
//        this.size = size;
//    }
//
//    public double next(int val) {
//        int windowSum = 0;
//        q.add(val);
//        for(int i= Math.max(0 ,q.size()-size); i<q.size();i++){
//            windowSum += (int)q.get(i);
//        }
//        return windowSum*1.0/Math.min(size,q.size());
//    }

    // Time complexity - O(N)
    // Space Complexity - O(N)

    int size, windowSum = 0, count= 0;
    Deque<Integer> deque = new LinkedList<>();
    public L346(int size) {
        this.size = size;
    }

    public double next(int val) {
        count++;
        deque.addLast(val);
        int tail = size < count ? (int)deque.pollFirst() : 0;
        windowSum = windowSum - tail + val;
        return windowSum*1.0/Math.min(count, size);
    }

    public static void main(String[] args) {
        L346 movingAverage = new L346(3);
        double ans1 = movingAverage.next(1); // return 1.0 = 1 / 1
        System.out.println(ans1);
        double ans2 = movingAverage.next(10); // return 5.5 = (1 + 10) / 2
        System.out.println(ans2);
        double ans3 = movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(ans3);
        double ans4 = movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
        System.out.println(ans4);
    }
}
