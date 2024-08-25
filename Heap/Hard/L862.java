package Heap.Hard;

// 862. Shortest Subarray with Sum at Least K

import java.util.Deque;
import java.util.LinkedList;

public class L862 {

    public static int shortestSubarray(int[] nums, int k) {
        int[] arr = new int[nums.length+1];
        int minLen = nums.length+1;
        for(int i=0;i< nums.length;i++){
            arr[i+1] = nums[i] + arr[i];
        }

        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<= nums.length;i++){
            while(!dq.isEmpty() && arr[i] < arr[dq.peekLast()]){
                dq.pollLast();
            }
            while(!dq.isEmpty() && arr[i] - arr[dq.peekFirst()] >= k){
                minLen = Math.min(minLen, i-dq.pollFirst());
            }
            dq.addLast(i);
        }
        if(minLen == nums.length+1)
            return -1;
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,2};
        int k = 3;
        System.out.println(shortestSubarray(nums, k));
    }
}

// Time Complexity - O((N)
// Space Complexity - O(N)