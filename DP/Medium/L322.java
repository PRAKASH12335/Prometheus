package DP.Medium;

// 322. Coin Change

import java.util.Arrays;

public class L322 {
    // DP space Optimised
    public static int coinChangeSpaceOptimized(int[] coins, int amount) {
        int[] prev = new int[amount+1], curr = new int[amount+1];
        int n = coins.length;
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0){
                prev[i] = i/coins[0];
            }else
                prev[i] = Integer.MAX_VALUE-1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake = prev[j];
                int take = Integer.MAX_VALUE-1;
                if(coins[i] <= j){
                    take = 1+curr[j-coins[i]];
                }
                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }
        int ans = prev[amount];
        if(ans >= Integer.MAX_VALUE-1) return -1;
        return ans;
    }

    //DP
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else
                dp[0][i] = Integer.MAX_VALUE-1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE-1;
                if(coins[i] <= j){
                    take = 1+dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans >= Integer.MAX_VALUE-1) return -1;
        return ans;
    }

    // Memoization
    public static  int coinChangeMemoHelper(int index, int[] coins, int amount, int [][] dp) {
        if(index == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            return Integer.MAX_VALUE-1;
        }
        if(dp[index][amount] != -1)
            return dp[index][amount];
        int notPick = coinChangeMemoHelper(index-1, coins, amount, dp);
        int pick = Integer.MAX_VALUE-1;
        if(coins[index] < amount){
            pick = 1 + coinChangeMemoHelper(index, coins, amount-coins[index], dp);
        }
        return dp[index][amount] = Math.min(notPick, pick);
    }

    public static  int coinChangeMemo(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return coinChangeMemoHelper(coins.length-1, coins, amount, dp);
    }

    // Recursion
    public static  int coinChangeHelper(int index, int[] coins, int amount) {
        if(index == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            return Integer.MAX_VALUE-1;
        }
        int notPick = coinChangeHelper(index-1, coins, amount);
        int pick = Integer.MAX_VALUE-1;
        if(coins[index] < amount){
            pick = 1 + coinChangeHelper(index, coins, amount-coins[index]);
        }
        return Math.min(notPick, pick);
    }

    public static  int coinChangeRec(int[] coins, int amount) {
        int ans = coinChangeHelper(coins.length-1, coins, amount);
        if(ans >= Integer.MAX_VALUE-1)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        int amount = 27;
        int[] coins = {2,5,10,1};
        System.out.println(coinChangeRec(coins, amount));
        System.out.println(coinChangeMemo(coins, amount));
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeSpaceOptimized(coins, amount));
    }
}


// Time Complexity - O(N*N)
// Space Complexity - 0(N)