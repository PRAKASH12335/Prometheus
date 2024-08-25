package DP.Medium;

public class L96 {

    // Recursion
    public static int numTrees(int n) {
        int sum = 0;
        int left = 0;
        int right = 0;
        if( n==0 || n ==1)
            return 1;
        for(int k=1;k<=n;k++){
            left = numTrees(k-1);
            right = numTrees(n-k);
            sum += left*right;
        }
        return sum;
    }

    //DP
    public static int numTreesDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int k=2;k<=n;k++){
            dp[k] = 0;
            for(int i=0;i<k;i++){
                dp[k] += dp[i]*dp[k-i-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numTrees(4));
        System.out.println(numTreesDP(4));
    }
}

// Time Complexity - O(n*n)
// Space Complexity - O(n)