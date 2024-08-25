package DP.Medium;

// 63. Unique Paths II

import java.util.Arrays;

public class L63 {

    // Recursion
    public static int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int m, int n) {
        if(m==0 && n == 0)
            return 1;
        if(m <0 || n< 0)
            return 0;
        if(obstacleGrid[m][n] == 1)
            return 0;
        int up = uniquePathsWithObstaclesHelper(obstacleGrid, m-1, n);
        int left = uniquePathsWithObstaclesHelper(obstacleGrid, m, n-1);
        return up+left;
    }
    public static int uniquePathsWithObstaclesRec(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return uniquePathsWithObstaclesHelper(obstacleGrid, m-1, n-1);
    }

    // Memoization
    public static int uniquePathsWithObstaclesMemoHelper(int[][] obstacleGrid, int m, int n,int[][] dp) {
        if(m==0 && n == 0)
            return 1;
        if(m <0 || n< 0)
            return 0;
        if(obstacleGrid[m][n] == 1)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        int up = uniquePathsWithObstaclesMemoHelper(obstacleGrid, m-1, n, dp);
        int left = uniquePathsWithObstaclesMemoHelper(obstacleGrid, m, n-1, dp);
        return dp[m][n] = up+left;
    }
    public static int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return uniquePathsWithObstaclesMemoHelper(obstacleGrid, m-1, n-1, dp);
    }

    //DP
    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
            return 0;
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++)
        {
            if(obstacleGrid[i][0]==1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i-1][0];
        }
        for(int j=1;j<n;j++)
        {
            if(obstacleGrid[0][j]==1)
                dp[0][j] = 0;
            else
                dp[0][j] = dp[0][j-1];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j] == 1)
                    dp[i][0] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        //int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstaclesRec(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesMemo(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesDP(obstacleGrid));
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)