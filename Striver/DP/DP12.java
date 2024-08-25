package Striver.DP;

import java.util.Arrays;

public class DP12 {

    // Recursion
    public static int maxPathSumHelper(int[][] nums, int ind, int row){
        if(ind < 0 || ind >= nums[0].length)
            return Integer.MIN_VALUE;
        if(row == 0)
            return nums[0][ind];
        int u = nums[row][ind] + maxPathSumHelper(nums, ind, row-1);
        int ld = nums[row][ind] + maxPathSumHelper(nums, ind-1, row-1);
        int rd = nums[row][ind] + maxPathSumHelper(nums, ind+1, row-1);
        return Math.max(u, Math.max(ld, rd));
    }
    public static int maxPathSum(int[][] nums){
        int m = nums.length;
        int n = nums[0].length, maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi, maxPathSumHelper(nums, i, m-1));
        }
        return maxi;
    }


    // Memoization
    public static int maxPathSumMemoHelper(int[][] nums, int ind, int row, int[][] dp){
        if(ind < 0 || ind >= nums[0].length)
            return Integer.MIN_VALUE;
        if(row == 0)
            return nums[0][ind];
        if(dp[row][ind] != -1)
            return dp[row][ind];
        int u = nums[row][ind] + maxPathSumMemoHelper(nums, ind, row-1, dp);
        int ld = nums[row][ind] + maxPathSumMemoHelper(nums, ind-1, row-1, dp);
        int rd = nums[row][ind] + maxPathSumMemoHelper(nums, ind+1, row-1, dp);
        return dp[row][ind] = Math.max(u, Math.max(ld, rd));
    }
    public static int maxPathSumMemo(int[][] nums){
        int m = nums.length;
        int n = nums[0].length, maxi = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi, maxPathSumMemoHelper(nums, i, m-1, dp));
        }
        return maxi;
    }

    // DP
    public static int maxPathSumDP(int[][] nums){
        int m = nums.length, n = nums[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = nums[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++) {
                int up = nums[i][j]+dp[i-1][j];
                int ld = nums[i][j];
                if(j-1>=0) ld += dp[i-1][j-1];
                int rd = nums[i][j];
                if(j+1<n)rd += dp[i-1][j+1];
                dp[i][j] = Math.max(up, Math.max(ld, rd));
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[m-1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        System.out.println(maxPathSum(nums));
        System.out.println(maxPathSumMemo(nums));
        System.out.println(maxPathSumDP(nums));
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)