package Heap.Medium;

// 215. Kth Largest Element in an Array

import java.util.PriorityQueue;

public class L215 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int num : nums){
            minPQ.add(num);
            if(minPQ.size() > k)
                minPQ.poll();
        }
        return minPQ.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k =4;
        System.out.println(findKthLargest(nums, k));
    }
}

// Time Complexity - O(NlogK)
// Space Complexity - O(K)