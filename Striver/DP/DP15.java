package Striver.DP;

import java.util.Arrays;

//DP15 Partition Equal Subset Sum

public class DP15 {

    // DP
    public static boolean subsetSumTargetDP(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }
        if(nums[0] < target)
            dp[0][nums[0]] = true;

        for(int i=1;i< nums.length;i++){
            for(int j=1;j<= target;j++){
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(nums[i] <= j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j] = notPick || pick;
            }
        }
        return dp[nums.length-1][target];
    }

    public static boolean canPartition(int[] nums){
        int sum = Arrays.stream(nums).sum();
        if(sum%2 == 0)
            return subsetSumTargetDP(nums, sum/2);
        else
            return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,4};
        System.out.println(canPartition(nums));
    }
}
