package DP.Medium;

// 1143. Longest Common Subsequence

import java.util.Arrays;

public class L1143 {

    // Recursion
    public static int lcsRecHelper(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if(s1.charAt(m-1) ==  s2.charAt(n-1))
            return 1 + lcsRecHelper(s1, s2, m-1, n-1);
        else
            return Math.max(lcsRecHelper(s1, s2, m-1, n), lcsRecHelper(s1, s2, m, n-1));
    }

    public static int lscRec(String text1, String text2) {
        return lcsRecHelper(text1, text2, text1.length(), text2.length());
    }

    // Memoization
    public static int lcsMemoHelper(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt(m-1) ==  s2.charAt(n-1))
            return dp[m][n] = 1 + lcsMemoHelper(s1, s2, m-1, n-1, dp);
        else
            return dp[m][n] = Math.max(lcsMemoHelper(s1, s2, m-1, n, dp), lcsMemoHelper(s1, s2, m, n-1, dp));
    }

    public static int lscMemo(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return lcsMemoHelper(text1, text2, m, n, dp);
    }

    // DP
    public static int lscDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 0;
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    // DP - Print LCS
    public static int[][] printLcsHelper(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 0;
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp;
    }

    public static String printLcs(String s1, String s2){
        int[][] dp = printLcsHelper(s1, s2);
        int i = dp.length-1, j = dp[0].length-1;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(lscRec(text1, text2));
        System.out.println(lscMemo(text1, text2));
        System.out.println(lscDP(text1, text2));
        System.out.println(printLcs(text1, text2));
    }
}
