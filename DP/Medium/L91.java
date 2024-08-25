package DP.Medium;

import java.util.Arrays;

public class L91 {

    // Recursion
    public static int numDecodingsRecHelper(String s, int index) {
        if(index == s.length())
            return 1;
        if(s.charAt(index)=='0') return 0;
        int res = numDecodingsRecHelper(s, index+1);
        if(index < (s.length()-1) && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index+1) < '7')){
            res += numDecodingsRecHelper(s, index+2);
        }
        return res;
    }

    public static int numDecodingsRec(String s) {
        if(s.length() == 0)
            return 0;
        return numDecodingsRecHelper(s, 0);
    }


    // Memoization
    public static int numDecodingsMemoHelper(String s, int index, int[] dp) {
        if(index == s.length())
            return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index] != -1)
            return dp[index];
        int res = numDecodingsMemoHelper(s, index+1, dp);
        if(index < (s.length()-1) && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index+1) < '7')){
            res += numDecodingsMemoHelper(s, index+2, dp);
        }
        return dp[index] = res;
    }

    public static int numDecodingsMemo(String s) {
        if(s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodingsMemoHelper(s, 0, dp);
    }


    // DP
    public static int numDecodingsDP(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '0')
                dp[i] = 0;
            else{
                dp[i] += dp[i+1];
                if (i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodingsRec(s));
        System.out.println(numDecodingsMemo(s));
        System.out.println(numDecodingsDP(s));
    }
}
