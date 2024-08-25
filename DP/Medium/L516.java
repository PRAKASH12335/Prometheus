package DP.Medium;

//Given a string s, find the longest palindromic subsequence's length in s.
//A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
//Example 1:
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".

public class L516 {

    // Recursion
    public static int longestPalindromeSubseqRec(String s) {
        return longestPalindromeSubseqRecHelper(s, 0, s.length()-1);
    }

    public static int longestPalindromeSubseqRecHelper(String s, int start, int end) {
        if(start > end) return 0;
        if(start == end) return 1;
        if(s.charAt(start) == s.charAt(end)){
            return 2 + longestPalindromeSubseqRecHelper(s, start+1, end-1);
        }else
            return Math.max(longestPalindromeSubseqRecHelper(s, start+1, end), longestPalindromeSubseqRecHelper(s, start, end-1));
    }

    // DP
    public static int lcs(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 0;
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        return lcs(s, t);
    }

    public static int longestPalindromeSubseqDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] = 1;
        }

        for(int k=2;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j =i+k-1;
                if(s.charAt(i) == s.charAt(j) && k ==2)
                    dp[i][j] = 2;
                else if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2+dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseqRec(s));
        System.out.println(longestPalindromeSubseqDP(s));
        System.out.println(longestPalindromeSubseq(s));
    }
}

// Time Complexity - O(n*n)
// Space Complexity - 0(n*n)