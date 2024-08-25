package DP.Hard;

// 2742. Painting the Walls

public class L2742 {
    int n;
    int[][] dp;

    public int f(int i, int remain, int[] cost, int[] time){
        if(remain <= 0)
            return 0;
        if(i == n)
            return (int) 1e9;
        if(dp[i][remain] != 0)
            return dp[i][remain];
        int paint = cost[i] + f(i+1, remain-1-cost[i], cost, time);
        int dontPaint = f(i+1, remain, cost, time);
        return dp[i][remain] = Math.min(paint, dontPaint);
    }

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new int[n][n+1];
        return f(0, n, cost, time);
    }

    public static void main(String[] args) {
        int[] cost = {1,2,3,2}, time = {1,2,3,2};
        L2742 obj = new L2742();
        System.out.println(obj.paintWalls(cost, time));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)