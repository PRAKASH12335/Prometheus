package Misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQ {

    private static int calculateKVul(PriorityQueue<Integer> pq, int[] arr, int k){
        for(int i : arr){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }

    private static int[] findKthVulnerability(int[] nums, int m , int k){
        int n = nums.length;
        int[] ans = new int[n-m+1];
        int[] arr = new int[m];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<m;i++){
            arr[i] = nums[i];
        }
        ans[0] = calculateKVul(pq, arr, k);
        pq.clear();

        for(int i=m;i<nums.length;i++){
            arr[i%m] = nums[i];
            ans[i-m+1] = calculateKVul(pq, arr, k);
            pq.clear();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 1};
        int m = 4;
        int k = 3;

        int[] ans = findKthVulnerability(nums, m, k);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}
