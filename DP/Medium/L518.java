package DP.Medium;

import java.util.Arrays;

public class L518 {

    // Recursion
    public static int changeRecHelper(int index, int amount, int[] coins) {
        if(index == 0){
            if(amount % coins[0] == 0)
                return 1;
        }
        int dontPick = 0+changeRecHelper(index-1, amount-0, coins);
        int pick = 0;
        if(coins[index] <= amount){
            pick = changeRecHelper(index, amount-coins[index], coins);
        }
        return pick+dontPick;
    }

    // Memoization
    public static int changeRec(int amount, int[] coins) {
        int n = coins.length;
        return changeRecHelper(n-1, amount, coins);
    }

    public static int changeMemoHelper(int index, int amount, int[] coins, int[][] dp) {
        if(index == 0){
            if(amount % coins[0] == 0)
                return 1;
        }
        if(dp[index][amount] != -1)
            return dp[index][amount];
        int dontPick = 0+changeMemoHelper(index-1, amount-0, coins, dp);
        int pick = 0;
        if(coins[index] <= amount){
            pick = changeMemoHelper(index, amount-coins[index], coins, dp);
        }
        return dp[index][amount] = pick+dontPick;
    }

    public static int changeMemo(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        return changeMemoHelper(n-1, amount, coins, dp);
    }

    // DP
    public static int changeDP(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int i = 0;i<=amount;i++) {
            if(i % coins[0] == 0) dp[0][i] = 1;
        }

        for(int i = 1;i<n;i++) {
            for(int j = 0;j<=amount;j++) {
                int dontPick = dp[i-1][j];
                int pick = 0;
                if(coins[i] <= j) {
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = dontPick + pick;
            }
        }
        return dp[n-1][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(changeRec(amount, coins));
        System.out.println(changeMemo(amount, coins));
        System.out.println(changeDP(amount, coins));
    }
}

// Time Complexity - 0(N*N)
// Space Complexity - 0(N*N)