package DP.Hard;

// 10. Regular Expression Matching

public class L10 {

    public static boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=1;j<=n;j++){
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-2];
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "ab", p = ".*";
        System.out.println(isMatchDP(s, p));
    }
}
