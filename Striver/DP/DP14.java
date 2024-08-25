package Striver.DP;

import java.util.Arrays;

//DP14 Subset Sum Equals to Target

public class DP14 {

    // Recursion
    public static boolean subsetSumTargetRecHelper(int[] nums, int target, int index){
        if(target == 0) return true;
        if(index == 0) {
            return nums[0] == target;
        }
        boolean notPick = subsetSumTargetRecHelper(nums, target, index-1);
        boolean pick = false;
        if(nums[index] <= target){
            pick = subsetSumTargetRecHelper(nums, target-nums[index], index-1);
        }
        return notPick || pick;
    }


    public static boolean subsetSumTargetRec(int[] nums, int target){
        return subsetSumTargetRecHelper(nums, target, nums.length-1);
    }


    // Memoization
    public static boolean subsetSumTargetMemoHelper(int[] nums, int target, int index, int[][] dp){
        if(target == 0) return true;
        if(index == 0) {
            return nums[0] == target;
        }
        if(dp[index][target] != -1)
            return dp[index][target] == 0 ? false : true;
        boolean notPick = subsetSumTargetMemoHelper(nums, target, index-1, dp);
        boolean pick = false;
        if(nums[index] <= target){
            pick = subsetSumTargetMemoHelper(nums, target-nums[index], index-1, dp);
        }
        dp[index][target] = notPick || pick ? 1 : 0;
        return notPick || pick;
    }

    public static boolean subsetSumTargetMemo(int[] nums, int target){
        int[][] dp = new int[nums.length][target+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return subsetSumTargetMemoHelper(nums, target, nums.length-1, dp);
    }

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


    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,4};
        int target = 4;
        System.out.println(subsetSumTargetRec(nums, target));
        System.out.println(subsetSumTargetMemo(nums, target));
        System.out.println(subsetSumTargetDP(nums, target));
    }
}

// Time Complexity - O(n*target)
// Space Complexity - O(n*target)