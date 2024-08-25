package Striver.DP;

// DP 17. Counts Subsets with Sum K

import java.util.Arrays;

public class DP17 {

    public static int countSubsetWithtarget(int[] nums, int target){
        int[][] dp = new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0] = 1;
        }
        if(nums[0] <= target)
            dp[0][nums[0]] = 1;

        for(int i=1;i< nums.length;i++){
            for(int j=1;j<= target;j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(nums[i] <= j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j] = notPick + pick;
            }
        }
        return dp[nums.length-1][target];
    }

    public static int countSubsetWithDiff(int[] nums, int diff){
        // s1+s2 = sum
        // s1-s2 = diff
        // s1 = diff+s2
        // diff+s2+s2 = sum
        // s2 = (sum - diff)/2
        int sum = Arrays.stream(nums).sum();
        int target = 0;
        if(sum - diff < 0 || (sum - diff) % 2 == 1)
            return 0;
        return countSubsetWithtarget(nums, (sum - diff)/2);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,4};
        int k = 4;
        System.out.println(countSubsetWithtarget(nums, k));

        // DP 18. Count Partitions With Given Difference
        int[] arr = {5,2,6,4};
        int diff = 3;
        System.out.println(countSubsetWithDiff(arr, diff));
    }
}
