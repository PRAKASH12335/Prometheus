package DP.Medium;

// 1048. Longest String Chain

import java.util.Arrays;

public class L1048 {

    public static boolean check(String a, String b){
        if(a.length() != b.length()+1)
            return false;
        int first = 0;
        int second = 0;
        while(first < a.length()){
            if(second < b.length() && a.charAt(first) == b.charAt(second)){
                first++;
                second++;
            }else
                first++;
        }
        return first == a.length() && second == b.length();
    }

    public static int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (a, b) -> a.length()-b.length());

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i], words[j]) && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(words));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N)