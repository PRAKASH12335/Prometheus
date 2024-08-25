package DP.Hard;

import java.util.Arrays;

// 10. Wildcard Matching

public class L44 {

    // Recursion
    public static boolean isMatchRecHelper(String s, String p, int m, int n) {
        if(m < 0 && n < 0)
            return true;
        if(m >= 0 && n < 0)
            return false;
        if(m < 0 && n >= 0){
            for(int i=0;i<=n;i++){
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '?'){
            return isMatchRecHelper(s, p, m-1, n-1);
        }else if(p.charAt(n) == '*'){
            return isMatchRecHelper(s, p, m, n-1) || isMatchRecHelper(s, p, m-1, n);
        }else
            return false;
    }

    public static boolean isMatchRec(String s, String p){
        return isMatchRecHelper(s, p, s.length()-1, p.length()-1);
    }


    // Memoization
    public static boolean isMatchMemoHelper(String s, String p, int m, int n, int[][] dp) {
        if(m == 0 && n == 0)
            return true;
        if(m > 0 && n == 0)
            return false;
        if(m == 0 && n > 0){
            for(int i=1;i<=n;i++){
                if(p.charAt(i-1) != '*')
                    return false;
            }
            return true;
        }
        if(dp[m][n] != -1)
            return dp[m][n] == 1 ? true : false;

        if(s.charAt(m-1) == p.charAt(n-1) || p.charAt(n-1) == '?'){
            dp[m][n] = isMatchMemoHelper(s, p, m-1, n-1, dp) == true ? 1 : 0;
            return dp[m][n] == 1 ? true : false;
        }else if(p.charAt(n-1) == '*'){
            dp[m][n] = (isMatchMemoHelper(s, p, m, n-1, dp) || isMatchMemoHelper(s, p, m-1, n, dp)) == true ? 1 : 0;
            return dp[m][n] == 1 ? true : false;
        }else {
            dp[m][n] = 0;
            return false;
        }
    }

    public static boolean isMatchMemo(String s, String p){
        int[][] dp = new int[s.length()+1][p.length()+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return isMatchMemoHelper(s, p, s.length(), p.length(), dp);
    }

    //DP
    public static boolean isMatchDP(String s, String p){
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=1;j<=n;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa", p = "*";
        System.out.println(isMatchRec(s, p));
        System.out.println(isMatchMemo(s, p));
        System.out.println(isMatchDP(s, p));
    }
}

// Time complexity - O(M*N)
// Space complexity - O(M*N)