package DP.Medium;

// 931. Minimum Falling Path Sum

import java.util.Arrays;

public class L931 {

    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 1)
            return matrix[0][0];
        int[][] dp = Arrays.copyOf(matrix, matrix.length);

        for(int i= matrix.length-2;i>=0;i--){
            for(int j=0;j< matrix.length;j++){
                int minPath = dp[i+1][j];
                if(j>0)
                    minPath = Math.min(minPath, dp[i+1][j-1]);
                if(j<matrix.length-1)
                    minPath = Math.min(minPath, dp[i+1][j+1]);
                dp[i][j] += minPath;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        L931 obj = new L931();
        System.out.println(obj.minFallingPathSum(matrix));
    }
}

// Time complexity - O(N^2)
// Space complexity - O(N^2)