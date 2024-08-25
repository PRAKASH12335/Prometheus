package DP.Medium;

// 647. Palindromic Substrings

//Given a string s, return the number of palindromic substrings in it.
//A string is a palindrome when it reads the same backward as forward.
//A substring is a contiguous sequence of characters within the string.
//
//Example 1:
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".

public class L647 {


    // DP
    public static int countSubstrings(String s) {
        if(s.length() == 0)
            return 0;
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = true;
            count++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                count++;
            }
        }

        for(int k=3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j = i+k-1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}

// Time Complexity - O(n2)
// Space Complexity - 0(n2)