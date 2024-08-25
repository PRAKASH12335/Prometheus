package DP.Medium;

public class L221 {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxx = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    maxx = 1;
                }else
                    dp[i][j] = 0;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(dp[i][j] == 1) {
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
                maxx = Math.max(maxx, dp[i][j]);
            }
        }
        return maxx*maxx;
    }
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                                       {'1','0','1','1','1'},
                                       {'1','1','1','1','1'},
                                       {'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)