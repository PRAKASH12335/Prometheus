package DP.Hard;

//123. Best Time to Buy and Sell Stock III
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//Find the maximum profit you can achieve. You may complete at most two transactions.
//Example 1:
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6

import java.util.Arrays;

public class L123 {

    // Recursion
    public static int maxProfitRecHelper(int[] prices, int index, int buy, int cap) {
        if(index == prices.length || cap == 0)
            return 0;
        if(buy == 1){
            return Math.max(-prices[index] + maxProfitRecHelper(prices, index+1, buy-1, cap),
                            maxProfitRecHelper(prices, index+1, buy, cap));
        }
        return Math.max(prices[index] + maxProfitRecHelper(prices, index+1, buy+1, cap-1),
                        maxProfitRecHelper(prices, index+1, buy, cap));
    }
    public static int maxProfitRec(int[] prices) {
        return maxProfitRecHelper(prices, 0, 1, 2);
    }

    // Memoization
    public static int maxProfitMemoHelper(int[] prices, int index, int buy, int cap, int[][][] dp) {
        if(index == prices.length || cap == 0)
            return 0;
        if(dp[index][buy][cap] != -1)
            return dp[index][buy][cap];
        if(buy == 1){
            return dp[index][buy][cap] = Math.max(-prices[index] + maxProfitMemoHelper(prices, index+1, buy-1, cap, dp),
                    maxProfitMemoHelper(prices, index+1, buy, cap, dp));
        }
        return dp[index][buy][cap] = Math.max(prices[index] + maxProfitMemoHelper(prices, index+1, buy+1, cap-1, dp),
                maxProfitMemoHelper(prices, index+1, buy, cap, dp));
    }
    public static int maxProfitMemo(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        Arrays.stream(dp).forEach(a -> Arrays.stream(a).forEach(b -> Arrays.fill(b, -1)));
        return maxProfitMemoHelper(prices, 0, 1, 2, dp);
    }


    // DP
    public static int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if (buy == 1) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind+1][buy-1][cap], dp[ind+1][buy][cap]);
                    }
                    else if(buy == 0){
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind+1][buy+1][cap-1], dp[ind+1][buy][cap]);
                    }
                }
            }
        }

//        for(int i=0;i<=n;i++){
//            for(int buy=0;buy<=1;buy++) {
//                for (int cap = 1; cap <= 2; cap++) {
//                    System.out.print(dp[i][buy][cap]+ " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        return dp[0][1][2];
    }

    // 188. Best Time to Buy and Sell Stock IV
    // DP
    public static int maxProfitKtimesDP(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=1;buy>=0;buy--){
                for(int cap=1;cap<=k;cap++){
                    if (buy == 1) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind+1][buy-1][cap], dp[ind+1][buy][cap]);
                    }
                    if(buy == 0){
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind+1][buy+1][cap-1], dp[ind+1][buy][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 3;
        System.out.println(maxProfitRec(prices));
        System.out.println(maxProfitMemo(prices));
        System.out.println(maxProfitDP(prices));
        System.out.println(maxProfitKtimesDP(prices, k));
    }
}


