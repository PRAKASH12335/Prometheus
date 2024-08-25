package Striver.DP;

// DP 30. Minimum Insertions/Deletions to Convert String A to String B

public class DP30 {

    public static int lcs(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 0;
        for(int j=0;j<=n;j++)
            dp[0][j] = 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    public static int minInsertionDeletion(String word1, String word2) {
        return word1.length()+word2.length() - 2*lcs(word1, word2);
    }

    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        System.out.println(minInsertionDeletion(s1, s2));
    }
}
