package DP.Hard;

import java.util.Arrays;

// Palindrome Partitioning – II | Front Partition

public class L132 {

    public static boolean isPalindrone(int i, int j, String temp){
        while(i<j){
            if(temp.charAt(i++) != temp.charAt(j--))
                return false;
        }
        return true;
    }

    // Recursion
    public static int minCutRecHelper(String s, int index) {
        if(index == s.length())
            return 0;
        int mini= Integer.MAX_VALUE;

        for(int j=index;j<s.length();j++){
            if(isPalindrone(index, j, s)){
                int minCut = 1 + minCutRecHelper(s, j+1);
                mini = Math.min(mini, minCut);
            }
        }
        return mini;
    }


    // Memoization
    public static int minCutRec(String s) {
        return minCutRecHelper(s, 0)-1;
    }

    // Recursion
    public static int minCutMemoHelper(String s, int index, int[] dp) {
        if(index == s.length())
            return 0;
        int mini= Integer.MAX_VALUE;
        if(dp[index] != -1)
            return dp[index];

        for(int j=index;j<s.length();j++){
            if(isPalindrone(index, j, s)){
                int minCut = 1 + minCutMemoHelper(s, j+1, dp);
                mini = Math.min(mini, minCut);
            }
        }
        return dp[index] = mini;
    }

    public static int minCutMemo(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return minCutMemoHelper(s, 0, dp)-1;
    }


    // DP
    public static int minCutDP(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int mini= Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrone(i, j, s)){
                    int minCut = 1 + dp[j+1];
                    mini = Math.min(mini, minCut);
                }
            }
            dp[i] = mini;
        }
        return dp[0]-1;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCutRec(s));
        System.out.println(minCutMemo(s));
        System.out.println(minCutDP(s));
    }
}

// Time complexity - O(N^2)
// Reason: There are a total of N states and inside each state a loop of size N(apparently) is running
// Space complexity - O(N)