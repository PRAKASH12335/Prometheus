package Striver.DP;

import java.util.Arrays;

//DP16 Partition A Set Into Two Subsets With Minimum Absolute Sum Difference

public class DP16 {

    public static boolean[][] subsetSumTargetDPArray(int[] nums, int target){
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
        return dp;
    }

    public static int minAbsoluteSumDifference(int[] nums){
        int n = nums.length;
        int target = Arrays.stream(nums).sum();
        boolean[][] dp = subsetSumTargetDPArray(nums, target);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=target/2;i++){
            if(dp[n-1][i] == true){
                int s1 = i;
                int s2 = target-i;
                ans = Math.min(ans, Math.abs(s2-s1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,4};
        System.out.println(minAbsoluteSumDifference(nums));
    }
}
