package DP.Medium;

// DP 33. Edit Distance

import java.util.Arrays;

public class L72 {

    // Recursion
    public static int minDistanceRecHelper(String word1, String word2, int m, int n) {
        if(m == 0 || n == 0)
            return m == 0 ? n : m;
        if(word1.charAt(m-1) == word2.charAt(n-1))
            return minDistanceRecHelper(word1, word2, m-1, n-1);
        else{
            int insert = minDistanceRecHelper(word1, word2, m, n-1);
            int delete = minDistanceRecHelper(word1, word2, m-1, n);
            int replace = minDistanceRecHelper(word1, word2, m-1, n-1);
            return 1+ Math.min(replace, Math.min(insert, delete));
        }
    }

    public static int minDistanceRec(String word1, String word2) {
        return minDistanceRecHelper(word1, word2, word1.length(), word2.length());
    }


    // Memoization
    public static int minDistanceMemoHelper(String word1, String word2, int m, int n, int[][] dp) {
        if(m == 0 || n == 0)
            return m == 0 ? n : m;
        if(dp[m-1][n-1] != -1)
            return dp[m-1][n-1];
        if(word1.charAt(m-1) == word2.charAt(n-1))
            return dp[m-1][n-1] = minDistanceMemoHelper(word1, word2, m-1, n-1, dp);
        else{
            int insert = minDistanceMemoHelper(word1, word2, m, n-1, dp);
            int delete = minDistanceMemoHelper(word1, word2, m-1, n, dp);
            int replace = minDistanceMemoHelper(word1, word2, m-1, n-1, dp);
            return dp[m-1][n-1] = 1+ Math.min(replace, Math.min(insert, delete));
        }
    }

    public static int minDistanceMemo(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return minDistanceMemoHelper(word1, word2, word1.length(), word2.length(), dp);
    }

    // DP
    public static int minDistanceDP(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            dp[i][0] = i;
        for(int j=0;j<=n;j++)
            dp[0][j] = j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "hros";
        System.out.println(minDistanceRec(word1, word2));
        System.out.println(minDistanceMemo(word1, word2));
        System.out.println(minDistanceDP(word1, word2));
    }
}
