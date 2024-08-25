package Striver.DP;

// Please do LCS before this question
// DP 27. Longest Common Substring

public class DP27 {

    public static int CommonSubstringDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 0;
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;

        int ans = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }

        for(int i=0;i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcjklp", s2 = "acjkp";
        System.out.println(CommonSubstringDP(s1, s2));
    }
}
