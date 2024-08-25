package Heap.Hard;

// 480. Sliding Window Median

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class L480 {
    public static void add(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ, int num){
        if(maxPQ.size() == 0)
            maxPQ.add(num);
        else {
            if (num <= maxPQ.peek()){
                maxPQ.add(num);
            }else
                minPQ.add(num);
        }
        adjust(minPQ, maxPQ);
    }

    public static void remove(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ, int num){
        if(maxPQ.size() == 0)
            minPQ.remove(num);
        else if (minPQ.size() == 0){
            maxPQ.remove(num);
        } else {
            if (num <= maxPQ.peek()){
                maxPQ.remove(num);
            }else
                minPQ.remove(num);
        }
        adjust(minPQ, maxPQ);
    }

    public static void adjust(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ){
        if(maxPQ.size() - minPQ.size() > 1){
            minPQ.add(maxPQ.poll());
        } else if (maxPQ.size() < minPQ.size()){
            maxPQ.add(minPQ.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ){
        int size = maxPQ.size() + minPQ.size();
        if(size % 2 == 1)
            return (double)maxPQ.peek();
        else
            return (double)maxPQ.peek()/2 + (double)minPQ.peek()/2;
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return null;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            add(minPQ, maxPQ, nums[i]);
        }

        double[] median = new double[nums.length-k+1];
        median[0] = getMedian(minPQ, maxPQ);
        for(int i=k;i<nums.length;i++){
            remove(minPQ, maxPQ, nums[i-k]);
            add(minPQ, maxPQ, nums[i]);
            median[i-k+1] = getMedian(minPQ, maxPQ);
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = medianSlidingWindow(nums, k);
        Arrays.stream(result).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O((N-K+1)logK)
// Space Complexity - O(K)
