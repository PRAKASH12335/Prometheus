package Heap.Easy;

// 1464. Maximum Product of Two Elements in an Array

import java.util.Collections;
import java.util.PriorityQueue;

public class L1464 {

    // PQ
    public static int maxProductPQ(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.add(num);
        }

        int second = pq.poll();
        int first = pq.poll();
        return (first-1)*(second-1);
    }

    public static int maxProduct(int[] nums) {
        int first = nums[0], second = nums[1];
        if(first < second){
            int temp = first;
            first = second;
            second = temp;
        }
        for(int i=2;i< nums.length;i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
            }else if(nums[i] < first && nums[i] > second){
                second = nums[i];
            }
        }
        return (first-1)*(second-1);
    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductPQ(nums));
    }
}
