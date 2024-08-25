package DP.Easy;

import java.util.Arrays;

public class L746 {

    // Recursion
     public static int minCostClimbingStairsHelper(int index,int[] cost){
         if(index == cost.length)
             return 0;
         if(index == cost.length-1)
             return cost[index];
         int pick1 = cost[index] + minCostClimbingStairsHelper(index+1, cost);
         int pick2 = cost[index] + minCostClimbingStairsHelper(index+2, cost);
         return Math.min(pick1, pick2);
     }

     public static int minCostClimbingStairsRec(int[] cost) {
         return Math.min(minCostClimbingStairsHelper(0, cost), minCostClimbingStairsHelper(1, cost));
     }

    //Memoization
     public static int minCostClimbingStairsMemoHelper(int index,int[] cost, int[] dp){
         if(index == cost.length){
             dp[index] = 0;
             return 0;
         }
         if(index == cost.length-1){
             dp[index] = cost[index];
             return dp[index];
         }
         if(dp[index] != -1)
             return dp[index];
         int pick1 = cost[index] + minCostClimbingStairsMemoHelper(index+1, cost, dp);
         int pick2 = cost[index] + minCostClimbingStairsMemoHelper(index+2, cost, dp);
         return dp[index] = Math.min(pick1, pick2);
     }
     public static int minCostClimbingStairsMemo(int[] cost) {
         int n = cost.length;
         int[] dp = new int[n+1];
         Arrays.fill(dp, -1);
         int choice1 = minCostClimbingStairsMemoHelper(0, cost, dp);
         Arrays.fill(dp, -1);
         int choice2 = minCostClimbingStairsMemoHelper(1, cost, dp);
         return Math.min(choice1, choice2);
     }

     // DP
    public static int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = cost[n-1];
        for(int i=n-2;i>=0;i--){
            int op1 = dp[i+1];
            int op2 = dp[i+2];
            dp[i] = Math.min(op1, op2)+cost[i];
        }
        int a = dp[0];

        dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = cost[n-1];
        for(int i=n-2;i>0;i--){
            int op1 = dp[i+1];
            int op2 = dp[i+2];
            dp[i] = Math.min(op1, op2)+cost[i];
        }
        int b = dp[1];
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairsRec(cost));
        System.out.println(minCostClimbingStairsMemo(cost));
        System.out.println(minCostClimbingStairsDP(cost));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)