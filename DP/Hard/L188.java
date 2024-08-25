package DP.Hard;

// 188. Best Time to Buy and Sell Stock IV
// DP 38. Buy and Stock Sell IV

import java.util.Arrays;

public class L188 {

    // Recursion
    public int maxProfitRecHelper(int index, int transNo, int[] prices, int n, int k){
        if(index == n || transNo == 2*k)
            return 0;
        if(transNo % 2 == 0)
            return Math.max(-prices[index] + maxProfitRecHelper(index+1, transNo+1, prices, n, k),
                    maxProfitRecHelper(index+1, transNo, prices, n, k));
        else
            return Math.max(prices[index] + maxProfitRecHelper(index+1, transNo+1, prices, n, k),
                    maxProfitRecHelper(index+1, transNo, prices, n, k));
    }

    public int maxProfitRec(int k, int[] prices) {
        int n = prices.length;
        return maxProfitRecHelper(0, 0, prices, n, k);
    }


    // Memoization
    public int maxProfitMemoHelper(int index, int transNo, int[] prices, int n, int k, int[][] dp){
        if(index == n || transNo == 2*k)
            return 0;
        if(dp[index][transNo] != -1)
            return dp[index][transNo];
        if(transNo % 2 == 0)
            return dp[index][transNo] = Math.max(-prices[index] + maxProfitMemoHelper(index+1, transNo+1, prices, n, k, dp),
                    maxProfitMemoHelper(index+1, transNo, prices, n, k, dp));
        else
            return dp[index][transNo] = Math.max(prices[index] + maxProfitMemoHelper(index+1, transNo+1, prices, n, k, dp),
                    maxProfitMemoHelper(index+1, transNo, prices, n, k, dp));
    }

    public int maxProfitMemo(int k, int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2*k];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return maxProfitMemoHelper(0, 0, prices, n, k, dp);
    }

    // DP
    public int maxProfitDP(int k, int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n+1][2*k+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int transNo=2*k-1;transNo>=0;transNo--){
                if(transNo % 2 == 0)
                    dp[ind][transNo] = Math.max(-prices[ind] + dp[ind+1][transNo+1], dp[ind+1][transNo]);
                else
                    dp[ind][transNo] = Math.max(prices[ind] + dp[ind+1][transNo+1], dp[ind+1][transNo]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 3;
        L188 obj = new L188();
        System.out.println(obj.maxProfitRec(k, prices));
        System.out.println(obj.maxProfitMemo(k, prices));
        System.out.println(obj.maxProfitDP(k, prices));
    }
}
