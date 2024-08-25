package DP.Easy;

public class L338 {

    // Recursion
    public static int solve(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n % 2 == 0)
            return solve(n/2);
        else
            return 1+ solve(n/2);
    }
    public static int[] countBitsRecursion(int n) {
        int res[] = new int[n + 1];

        for(int i = 0; i <= n; i++){
            res[i] = solve(i);
        }
        return res;
    }

    // Memoization
    public static int solve(int n, int[] res){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(res[n] != -1)
            return res[n];
        if(n % 2 == 0)
            res[n] = solve(n/2);
        else
            res[n] = 1+ solve(n/2);
        return res[n];
    }
    public static int[] countBitsMemo(int n) {
        int res[] = new int[n + 1];

        for(int i = 0; i <= n; i++){
            res[i] = solve(i, res);
        }
        return res;
    }

    // DP
    public static int[] countBitsDP(int num) {
        int[] dp = new int[num+1];
        for(int i=0;i<=num;i++){
            dp[i] = dp[i/2] + (i&1);
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        // Recursion
        int[] result = countBitsRecursion(n);
        for(int i=0;i<=n;i++){
            System.out.println(result[i]);
        }
        // Memoization
        int[] res = countBitsMemo(n);
        for(int i=0;i<=n;i++){
            System.out.println(res[i]);
        }
        // DP
        int[] resDp = countBitsDP(n);
        for(int i=0;i<=n;i++){
            System.out.println(resDp[i]);
        }
    }
}

// Time complexity - O(N)
// Space complexity - O(N)