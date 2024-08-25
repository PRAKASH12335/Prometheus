package Striver.DP;

import java.util.Arrays;

public class DP51 {

    // Recursion
    public static int maxCoinsRecHelper(int i, int j, int[] nums){
        if(i>j)
            return 0;
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost = nums[i-1]*nums[k]*nums[j+1] + maxCoinsRecHelper(i, k-1, nums) + maxCoinsRecHelper(k+1, j, nums);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }

    public static int maxCoinsRec(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i=0;i<nums.length;i++){
            newNums[i+1] = nums[i];
        }
        return maxCoinsRecHelper(1, nums.length, newNums);
    }

    // Memoization
     public static int maxCoinsMemoHelper(int i, int j, int[] nums, int[][] dp){
         if(i>j)
             return 0;
         int maxi = Integer.MIN_VALUE;
         if(dp[i][j] != -1)
             return dp[i][j];
         for(int k=i;k<=j;k++){
             int cost = nums[i-1]*nums[k]*nums[j+1] + maxCoinsMemoHelper(i, k-1, nums, dp) + maxCoinsMemoHelper(k+1, j, nums, dp);
             maxi = Math.max(maxi, cost);
         }
         return dp[i][j] = maxi;
     }

     public static int maxCoinsMemo(int[] nums) {
         int[] newNums = new int[nums.length+2];
         newNums[0] = 1;
         newNums[nums.length+1] = 1;
         for(int i=0;i<nums.length;i++){
             newNums[i+1] = nums[i];
         }
         int[][] dp = new int[nums.length+1][nums.length+1];
         Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
         return maxCoinsMemoHelper(1, nums.length, newNums, dp);
     }

     // DP
     public static int maxCoinsDP(int[] nums) {
         int n = nums.length;
         int[] newArr = new int[n+2];
         newArr[0] = 1;
         newArr[n+1] = 1;
         for(int i=0;i<n;i++){
             newArr[i+1] = nums[i];
         }
         int[][] dp = new int[n+2][n+2];
         for(int i=n;i>=1;i--){
             for(int j=1;j<=n;j++){
                 if(i > j) continue;
                 int maxi = Integer.MIN_VALUE;
                 for(int k=i;k<=j;k++){
                     int cost = newArr[i-1]*newArr[k]*newArr[j+1] + dp[i][k-1] + dp[k+1][j];
                     maxi = Math.max(maxi, cost);
                 }
                 dp[i][j] = maxi;
             }
         }
         return dp[1][n];
     }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoinsRec(nums));
        System.out.println(maxCoinsMemo(nums));
        System.out.println(maxCoinsDP(nums));
    }
}

// Time complexity - O(N^3)
// Space complexity - O(N^2)