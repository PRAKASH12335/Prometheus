package DP.Easy;

// Buy and Sell Stock - II

public class L122 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            int diff = prices[i]-prices[i-1];
            if(diff>0){
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
}
