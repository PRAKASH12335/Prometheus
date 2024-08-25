package DP.Easy;

public class L70 {

    // DP Space Optimized
    public static int climbStairsDPSpace(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for(int i=2;i<=n;i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // DP
    public static int climbStairsDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Memoization
    public static int climbStairsMemo(int n, int[] dp) {
        if(n==0 || n == 1)
            return 1;
        if(dp[n] != -1)
            return dp[n];
        int one = climbStairs(n-1);
        int two = climbStairs(n-2);
        return dp[n] = one+two;
    }

    // Recursion
    public static int climbStairs(int n) {
        if(n==0 || n == 1)
            return 1;
        int one = climbStairs(n-1);
        int two = climbStairs(n-2);
        return one+two;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        System.out.println(climbStairsMemo(n, dp));
        System.out.println(climbStairsDP(n));
        System.out.println(climbStairsDPSpace(n));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)