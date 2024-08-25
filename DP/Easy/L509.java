package DP.Easy;

public class L509 {

    // DP spaceOptimizes
    public static int fibDPSpace(int n) {
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2;i<=n;i++){
            int curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // DP
    public static int fibDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // Recursion
    public static int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
        System.out.println(fibDP(n));
        System.out.println(fibDPSpace(n));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)