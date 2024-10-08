package DP.Hard;

// 1312. Minimum Insertion Steps to Make a String Palindrome
// DP 29. Minimum Insertions to Make String Palindrome

public class L1312 {

    public static int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String t = sb.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;
        for(int j=0;j<=n;j++)
            dp[0][j] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return n-dp[n][n];
    }

    public static void main(String[] args) {
        String s = "zzazz";
        System.out.println(minInsertions(s));
    }
}
