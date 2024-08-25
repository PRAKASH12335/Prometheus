package DP.Medium;

import java.util.*;

public class L139 {

    //Recursion
    public static boolean wordBreakHelper(String s, List<String> wordDict, int index) {
        if(index >= s.length())
            return true;
        for(int i=index;i<s.length();i++){
            if(wordDict.contains(s.substring(index, i+1))){
                if( wordBreakHelper(s, wordDict, i+1));
                    return true;
            }
        }
        return false;
    }

    public static boolean wordBreakRec(String s, List<String> wordDict){
        return wordBreakHelper(s, wordDict, 0);
    }

    // Memoization
    public static boolean wordBreakMemoHelper(String s, Set<String> set, Map<String, Boolean> dp) {
        if(s.length() == 0)
            return true;
        if (dp.containsKey(s))
            return dp.get(s);
        for(int i=0;i<s.length();i++){
            String str = s.substring(0, i+1);
            if(set.contains(str)){
                if(wordBreakMemoHelper(s.substring(i+1), set, dp)) {
                    dp.put(s, true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }

    public static boolean wordBreakMemo(String s, List<String> wordDict) {
        Set<String> m = new HashSet<>(wordDict);
        Map<String, Boolean> dp = new HashMap<>();
        return wordBreakMemoHelper(s, m, dp);
    }

    //DP
    public static boolean wordBreakDP(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");
        System.out.println(wordBreakRec(s, wordDict));
        System.out.println(wordBreakDP(s, wordDict));
        System.out.println(wordBreakMemo(s, wordDict));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N)