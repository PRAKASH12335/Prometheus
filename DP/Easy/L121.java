package DP.Easy;

// 121. Buy and Sell Stock - I
// 122. Buy and Sell Stock - II
// 123. Best Time to Buy and Sell Stock III
// 188. Best Time to Buy and Sell Stock IV
// 309. Best Time to Buy and Sell Stock with Cooldown
// 714. Best Time to Buy and Sell Stock with Transaction Fee

public class L121 {
    public static int maxProfit(int[] prices) {
        int profit = 0, min = prices[0];
        for(int i=1;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
}
