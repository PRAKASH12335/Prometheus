package DP.Medium;

import java.util.Arrays;

public class L376 {

    public static int wiggleMaxLengthDP(int[] nums) {
        if(nums.length == 0) return 0;
        int[] increasing = new int[nums.length];
        int[] decreasing = new int[nums.length];
        increasing[0] = 1;
        decreasing[0] = 1;
        for(int i=1;i<nums.length;i++){
            for(int j =0;j<i;j++){
                if(nums[i] > nums[j]){
                    increasing[i] = Math.max(increasing[i-1], decreasing[j]+1);
                }
                if(nums[i] < nums[j]){
                    decreasing[i] = Math.max(decreasing[i-1], increasing[j]+1);
                }
                if(nums[i] == nums[j]){
                    decreasing[i] = decreasing[i-1];
                    increasing[i] = increasing[i-1];
                }
            }
        }
        return Math.max(increasing[nums.length-1], decreasing[nums.length-1]);
    }

// Time Complexity - O(N*N)
// Space Complexity - 0(N)


    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        int increasing = 1, decreasing = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1])
                increasing = decreasing+1;
            else if (nums[i] < nums[i-1])
                decreasing = increasing+1;
        }
        return Math.max(increasing, decreasing);
    }

// Time Complexity - O(N)
// Space Complexity - 0(1)

    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
        System.out.println(wiggleMaxLengthDP(nums));
    }
}
