package DP.Medium;

// 64. Minimum Path Sum

import java.util.Arrays;

public class L64 {

    // Recursion
    public static int minPathSumRecHelper(int[][] grid, int m, int n) {
        if(m == 0 && n ==0)
            return grid[m][n];
        if(m < 0 && n < 0)
            return Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(m>0)
            down = grid[m][n] + minPathSumRecHelper(grid, m-1, n);
        if(n>0)
            right = grid[m][n] + minPathSumRecHelper(grid, m, n-1);
        return Math.min(down, right);
    }

    public static int minPathSumRec(int[][] grid) {
        return minPathSumRecHelper(grid, grid.length-1, grid[0].length-1);
    }


    // Memoization
    public static int minPathSumMemoHelper(int[][] grid, int m, int n, int[][] dp) {
        if(m == 0 && n ==0)
            return grid[m][n];
        if(m < 0 && n < 0)
            return Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(m>0)
            down = grid[m][n] + minPathSumMemoHelper(grid, m-1, n, dp);
        if(n>0)
            right = grid[m][n] + minPathSumMemoHelper(grid, m, n-1, dp);
        return dp[m][n] = Math.min(down, right);
    }

    public static int minPathSumMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return minPathSumMemoHelper(grid, grid.length-1, grid[0].length-1, dp);
    }

    // DP
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSumRec(grid));
        System.out.println(minPathSumMemo(grid));
        System.out.println(minPathSum(grid));
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)