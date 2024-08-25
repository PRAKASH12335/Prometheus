package DP.Medium;

// 304. Range Sum Query 2D - Immutable

public class L304 {

    int[][] dp;
    public L304(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    continue;
                }
                dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        // row1 = 3, col1 = 2, row =5, col2 = 4
//        0  0  0  0  0  0
//        0  3  3  4  8 10
//        0  8 14 18 24 27
//        0  9 17 21 28 36
//        0 13 22 26 34 49
//        0 14 23 30 38 58
        // 38-24-14+8
        return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[][] sumRegions = {{2, 1, 4, 3}, {1, 1, 2, 2}, {1, 2, 2, 4}};
        L304 obj = new L304(matrix);
        for(int[] region : sumRegions){
            int row1 = region[0];
            int col1 = region[1];
            int row2 = region[2];
            int col2 = region[3];
            System.out.println(obj.sumRegion(row1, col1, row2, col2));
        }
    }
}

// Time Complexity - O(M*N)
// Space Complexity - 0(M*N)