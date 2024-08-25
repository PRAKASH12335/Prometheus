package DP.Hard;

import java.util.Arrays;

// Minimum cost to cut the stick | (DP-50)

public class L1547 {

    // Recursion
    public static int recHelper(int i, int j, int[] cuts) {
        if(i > j) return 0;
        int mini = Integer.MAX_VALUE;
        for(int index=i;index<=j;index++){
            int cost = cuts[j+1] - cuts[i-1] + recHelper(i, index-1, cuts) + recHelper(index+1, j, cuts);
            mini = Math.min(mini, cost);
        }
        return mini;
    }
    public static int minCostRec(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        for(int i=0;i< cuts.length;i++){
            newCuts[i+1] = cuts[i];
        }
        newCuts[cuts.length+1] = n;
        Arrays.sort(newCuts);
        return recHelper(1, cuts.length, newCuts);
    }

    // Memoization
    public static int MemoHelper(int i, int j, int[] cuts, int[][] dp) {
        if(i > j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j] != -1)
            return dp[i][j];
        for(int index=i;index<=j;index++){
            int cost = cuts[j+1] - cuts[i-1] + MemoHelper(i, index-1, cuts, dp) + MemoHelper(index+1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
    public static int minCostMemo(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        for(int i=0;i< cuts.length;i++){
            newCuts[i+1] = cuts[i];
        }
        newCuts[cuts.length+1] = n;
        Arrays.sort(newCuts);
        int[][] dp = new int[cuts.length+1][cuts.length+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return MemoHelper(1, cuts.length, newCuts, dp);
    }


    // DP
    public static int minCostDP(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        for(int i=0;i< cuts.length;i++){
            newCuts[i+1] = cuts[i];
        }
        newCuts[cuts.length+1] = n;
        Arrays.sort(newCuts);
        int[][] dp = new int[cuts.length+2][cuts.length+2];
        for(int i=cuts.length;i>=1;i--){
            for(int j=i;j<=cuts.length;j++){
                if(i > j) continue;
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    mini = Math.min(mini, newCuts[j+1] - newCuts[i-1] + dp[i][k-1] + dp[k+1][j]);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][cuts.length];
    }

    public static void main(String[] args) {
        int[] cuts = {5,6,1,4,2};
        int n = 9;
        System.out.println(minCostRec(n, cuts));
        System.out.println(minCostMemo(n, cuts));
        System.out.println(minCostDP(n, cuts));
    }
}


// Time complexity - O(N^3)
//Reason: There are 2 variables i and j, therefore, N*N states and we explicitly run a loop inside the function which will run for N times,
//        therefore at max ‘N*N*N’ new problems will be solved.
// Space complexity - O(N)