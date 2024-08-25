package BinarySearch.Hard;

import java.util.Arrays;
import java.util.stream.IntStream;

// 410. Split Array Largest Sum

public class L410 {

    private static boolean isValid(int[] nums, int mid, int k) {
        int count =1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] <= mid){
                sum = sum+nums[i];
            }else{
                sum = nums[i];
                count++;
            }
        }
        return count <= k;
    }

    public static int splitArray(int[] nums, int k) {
        int low = IntStream.of(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high){
            int mid = low+(high-low)/2;
            if(isValid(nums, mid, k)){
                high = mid-1;
            }else
                low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
}

// Time Complexity - O(log sum-max+1)*O(n)
// Space Complexity - O(1)