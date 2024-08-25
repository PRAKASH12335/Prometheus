package DP.Medium;

// 309. Best Time to Buy and Sell Stock with Cooldown

import java.util.Arrays;

public class L309 {

    // similar to L714

    // DP
    public static int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[prices.length+2][2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1)
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                else
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind+2][1], dp[ind+1][0]);
            }
        }
        return dp[0][1];
    }


    // Memo
    public static int maxProfitMemo(int[] prices, int index, int buy, int[][] dp) {
        if(index >= prices.length)
            return 0;
        if(dp[index][buy] != -1)
            return dp[index][buy];
        if(buy == 1)
            return dp[index][buy] = Math.max(-prices[index] + maxProfitMemo(prices, index+1, 0, dp), maxProfitMemo(prices, index+1, 1, dp));
        else
            return dp[index][buy] = Math.max(prices[index] + maxProfitMemo(prices, index+2, 1, dp), maxProfitMemo(prices, index+1, 0, dp));
    }


    // Recursion
    public static int maxProfit(int[] prices, int index, int buy) {
        if(index >= prices.length)
            return 0;
        if(buy == 1)
            return Math.max(-prices[index] + maxProfit(prices, index+1, 0), maxProfit(prices, index+1, 1));
        else
            return Math.max(prices[index] + maxProfit(prices, index+2, 1), maxProfit(prices, index+1, 0));
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices, 0, 1));

        int[][] dp = new int[prices.length][2];
        for(int i=0;i< prices.length;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(maxProfitMemo(prices, 0, 1, dp));

        System.out.println(maxProfitDP(prices));
    }
}

// Time Complexity - O(N)
// Space Complexity - 0(N)