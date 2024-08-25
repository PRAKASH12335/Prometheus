package DP.Medium;

//Count Square Submatrices with All Ones
//
//Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
public class L1277 {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j];
                }
                else{
                    dp[i][j] = matrix[i][j] == 0 ? 0 : 1+ Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]));
                }
                res+=dp[i][j];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,1,1},
                                     {1,1,1,1},
                                     {0,1,1,1}};
        System.out.println(countSquares(matrix));
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)