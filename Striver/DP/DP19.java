package Striver.DP;

// DP 19. 0/1 Knapsack | Recursion to Single Array Space Optimised Approach | DP on Subsequences

public class DP19 {

    // DP Space Optimized
    public static int knapsackDPSpaceOptimized(int n, int maxWeight, int[] wt, int[] val){
        int[][] dp = new int[n+1][maxWeight+1];
        int[] prev = new int[maxWeight+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=maxWeight;j++){
                if(i==0 || j==0)
                    prev[j] = 0;
            }
        }

        for(int i=1;i<=n;i++){
            int[] curr = new int[maxWeight+1];
            for(int j=1;j<=maxWeight;j++){
                if(wt[i-1]<j)
                    curr[j] = Math.max(val[i-1]+prev[j-wt[i-1]], prev[j]);
                else
                    curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[maxWeight];
    }

    // DP
    public static int knapsackDP(int n, int maxWeight, int[] wt, int[] val){
        int[][] dp = new int[n+1][maxWeight+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=maxWeight;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxWeight;j++){
                if(wt[i-1]<j)
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][maxWeight];
    }


    // Memoization
    public static int knapsackMemo(int n, int maxWeight, int[] wt, int[] val, int[][] dp){
        if(n == 0 || maxWeight == 0)
            return 0;
        if(dp[n][maxWeight] != -1)
            return dp[n][maxWeight];
        if(wt[n-1] < maxWeight)
            return dp[n][maxWeight] = Math.max(val[n-1]+knapsackRec(n-1, maxWeight-wt[n-1], wt, val), knapsackRec(n-1, maxWeight, wt, val));
        else
            return dp[n][maxWeight] = knapsackRec(n-1, maxWeight, wt, val);
    }


    // Recursion
    public static int knapsackRec(int n, int maxWeight, int[] wt, int[] val){
        if(n == 0 || maxWeight == 0)
            return 0;
        if(wt[n-1] < maxWeight)
            return Math.max(val[n-1]+knapsackRec(n-1, maxWeight-wt[n-1], wt, val), knapsackRec(n-1, maxWeight, wt, val));
        else
            return knapsackRec(n-1, maxWeight, wt, val);
    }

    public static int knapsack(int maxWeight, int[] wt, int[] val){
        int n = wt.length;
        return knapsackRec(n, maxWeight, wt, val);

//        int[][] dp = new int[n][maxWeight+1];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<=maxWeight;j++){
//                dp[i][j] = -1;
//            }
//        }
//        return knapsackMemo(n-1, maxWeight, wt, val, dp);

        //return knapsackDP(n, maxWeight, wt, val);

        //return knapsackDPSpaceOptimized(n, maxWeight, wt, val);
    }


    public static void main(String[] args) {
        int weight = 6;
        int[] wt = new int[]{3,2,5};
        int[] val = new int[]{40,30,60};
        System.out.println(knapsack(weight, wt, val));
    }
}

// Time Complexity - O(n^2)
// Space Complexity - O(n)