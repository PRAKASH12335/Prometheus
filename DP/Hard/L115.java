package DP.Hard;

// 115. Distinct Subsequences

import java.util.Arrays;

public class L115 {

    // Recursion
    public static int numDistinctRecHelper(String s, String t, int i, int j) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(s.charAt(i) == t.charAt(j))
            return numDistinctRecHelper(s, t, i-1, j-1) + numDistinctRecHelper(s, t, i-1, j);
        else
            return numDistinctRecHelper(s, t, i-1, j);
    }

    public static int numDistinctRec(String s, String t) {
        return numDistinctRecHelper(s, t, s.length()-1, t.length()-1);
    }

    // Memoization
    public static int numDistinctMemoHelper(String s, String t, int i, int j, int[][] dp) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = numDistinctMemoHelper(s, t, i-1, j-1, dp) + numDistinctMemoHelper(s, t, i-1, j, dp);
        else
            return dp[i][j] = numDistinctMemoHelper(s, t, i-1, j, dp);
    }

    public static int numDistinctMemo(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return numDistinctMemoHelper(s, t, m-1, n-1, dp);
    }

    // DP
    public static int numDistinctDP(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = 1;
        }
        for(int j=1;j<=n;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s= "rabbbit", t = "rabbit";
        System.out.println(numDistinctRec(s, t));
        System.out.println(numDistinctMemo(s, t));
        System.out.println(numDistinctDP(s, t));
    }
}


// Time complexity - O(M*N)
// Space complexity - O(M*N)