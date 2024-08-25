package DP.Medium;

// 62. Unique Paths

public class L62 {

    // DP Space optimized
    public static int uniquePathsDPSpaceOptimized(int m, int n) {
        int[] prev = new int[n];

        for(int i=0;i<m;i++){
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 || j ==0){
                    curr[j] = 1;
                }else {
                    curr[j] = prev[j] + curr[j - 1];
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

    // DP
    public static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // Memoization
    public static int uniquePathsMemo(int m, int n, int[][] dp) {
        if(m == 0 && n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        int left = uniquePathsRecursion(m, n-1);
        int up = uniquePathsRecursion(m-1, n);
        return dp[m][n] = left+up;
    }


    // Recursion
    public static int uniquePathsRecursion(int m, int n) {
        if(m == 0 && n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;
        int left = uniquePathsRecursion(m, n-1);
        int up = uniquePathsRecursion(m-1, n);
        return left+up;
    }
    // Time Complexity - O(2^m*n)
    // Space Complexity - O(m-1+n-1)

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(uniquePathsRecursion(m-1, n-1));
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(uniquePathsMemo(m-1, n-1, dp));
        System.out.println(uniquePathsDP(m, n));
        System.out.println(uniquePathsDPSpaceOptimized(m, n));
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)