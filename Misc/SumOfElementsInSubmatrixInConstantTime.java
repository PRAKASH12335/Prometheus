package Misc;

// Calculate the sum of all elements in a submatrix in constant time

public class SumOfElementsInSubmatrixInConstantTime {

    public static int findSubmatrixSum(int[][] matrix, int p, int q, int r, int s){
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j] = matrix[0][j] + dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] ;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int rowSum = 0, colSum = 0, commonSum = 0;
        if(p-1 >= 0){
            rowSum = dp[p-1][s];
        }
        if(q-1 >= 0){
            colSum = dp[r][q-1];
        }
        if(p-1 >= 0 && q-1 >=0){
            commonSum = dp[p-1][q-1];
        }
        return dp[r][s] - colSum - rowSum + commonSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 2, 5, 4, 1},
                { 4, 8, 2, 3, 7},
                { 6, 3, 4, 6, 2},
                { 7, 3, 1, 8, 3},
                { 1, 5, 7, 9, 4}
        };
        int p=0, q=0, r=3, s = 3;
        System.out.println(findSubmatrixSum(matrix, p, q, r, s));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

// 0  2  7  11  12
// 4
// 10
// 17
// 10