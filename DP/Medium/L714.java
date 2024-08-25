package DP.Medium;

import java.util.Arrays;

// Best Time to Buy and Sell Stock with Transaction Fee
public class L714 {

    // Recusion
    public static int maxProfitUtil(int[] prices, int fee, int index, int buy){
        if(index >= prices.length)
            return 0;
        if(buy == 1){
            return Math.max(-prices[index]+ maxProfitUtil(prices, fee, index+1, 0)-fee,
                    maxProfitUtil(prices, fee, index+1, 1));
        }else{
            return Math.max(prices[index]+maxProfitUtil(prices, fee, index+1, 1),
                    maxProfitUtil(prices, fee, index+1, 0));
        }

    }
    public static int maxProfit(int[] prices, int fee) {
        if(prices.length == 0)
            return 0;
        return maxProfitUtil(prices, fee, 0, 1);
    }

    // Memoization
    private static int maxProfitHelper(int[] prices, int index, int buy, int fee, int[][] dp){
        if(index >= prices.length)
            return 0;
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        if(buy == 1){
            return dp[index][buy] = Math.max(-prices[index]+ maxProfitUtil(prices, fee, index+1, 0)-fee,
                    maxProfitUtil(prices, fee, index+1, 1));
        }else{
            return dp[index][buy] = Math.max(prices[index]+maxProfitUtil(prices, fee, index+1, 1),
                    maxProfitUtil(prices, fee, index+1, 0));
        }
    }

    // DP
    private static int maxProfitDP(int[] prices, int fee){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            dp[i][1] = Math.max(-prices[i]+ dp[i+1][0]-fee, dp[i+1][1]);
            dp[i][0] = Math.max(prices[i]+ dp[i+1][1], dp[i+1][0]);
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));

        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(maxProfitHelper(prices, 0, 1, fee, dp));

        System.out.println(maxProfitDP(prices, fee));
    }
}
