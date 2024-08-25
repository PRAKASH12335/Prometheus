package DP.Medium;

// 198. House Robber

import java.util.Arrays;

public class L198 {

    // DP Space Optimized
    public static int robDPSpace(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);

        int prev2 = nums[0];
        int prev1 = Math.max(nums[1], nums[0]);
        for(int i=2;i<nums.length;i++){
            int curr = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // DP
    public static int robDP(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    // Memoization
    public static int robMemoHelper(int index, int[] nums, int[] dp){
        if(index == 0){
            return nums[0];
        }
        if(index < 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        int notPick = 0, pick = 0;
        if(index > 0) {
            notPick = robMemoHelper(index - 1, nums, dp);
            pick = nums[index] + robMemoHelper(index - 2, nums, dp);
        }
        return dp[index] = Math.max(notPick, pick);
    }
    public static int robMemo(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robMemoHelper(nums.length-1, nums, dp);
    }

    // Recursion
    public static int robRecHelper(int index, int[] nums){
        if(index == 0){
            return nums[0];
        }
        if(index < 0)
            return 0;
        int notPick = 0, pick = 0;
        if(index > 0) {
            notPick = robRecHelper(index - 1, nums);
            pick = nums[index] + robRecHelper(index - 2, nums);
        }
        return Math.max(notPick, pick);
    }
    public static int robRec(int[] nums) {
        return robRecHelper(nums.length-1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(robRec(nums));
        System.out.println(robMemo(nums));
        System.out.println(robDP(nums));
        System.out.println(robDPSpace(nums));
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)