package DP.Medium;

import java.util.Arrays;

public class L279 {

    // Recursion
    public static int numSquaresRec(int n) {
        if(n<4)
            return n;
        int ans = n;
        for(int i=1;i*i<=n;i++) {
            int square = i*i;
            ans = Math.min(ans, 1+ numSquares(n-square));
        }
        return ans;
    }

    // Memo
    public static int numSquaresMemoHelper(int n, int[] dp) {
        if(n<4)
            return n;
        if(dp[n] != -1)
            return dp[n];
        int ans = n;
        for(int i=1;i*i<=n;i++) {
            int square = i*i;
            ans = Math.min(ans, 1+ numSquaresMemoHelper(n-square, dp));
        }
        return dp[n] = ans;
    }

    public static int numSquaresMemo(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return numSquaresMemoHelper(n, dp);
    }

    // DP
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1;i<=n;i++) {
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                int square = j*j;
                dp[i] = Math.min(dp[i], 1+dp[i-square]);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquaresRec(n));
        System.out.println(numSquaresMemo(n));
        System.out.println(numSquares(n));
    }
}

// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)