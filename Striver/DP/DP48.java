package Striver.DP;

// DP 49. Matrix Chain Multiplication

import java.util.Arrays;

public class DP48 {

    // Recursion
    public static int mcmRecHelper(int[] nums, int i, int j){
        if(i == j) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int minn = nums[i-1]*nums[k]*nums[j] + mcmRecHelper(nums, i, k) + mcmRecHelper(nums, k+1, j);
            ans = Math.min(ans, minn);
        }
        return ans;
    }

    public static int mcmRec(int[] nums){
        int n = nums.length;
        return mcmRecHelper(nums, 1, n-1);
    }

    // Memoization
    public static int mcmMemoHelper(int[] nums, int i, int j, int[][] dp){
        if(i == j) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[i][j] != -1)
            return dp[i][j];
        for(int k=i;k<j;k++){
            int minn = nums[i-1]*nums[k]*nums[j] + mcmMemoHelper(nums, i, k, dp) + mcmMemoHelper(nums, k+1, j, dp);
            ans = Math.min(ans, minn);
        }
        return dp[i][j] = ans;
    }

    public static int mcmMemo(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return mcmMemoHelper(nums, 1, n-1, dp);
    }


    // DP
    public static int mcmDP(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }
        for(int i =n-1;i>=1;i--){
            for(int j= i+1;j<n;j++){
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps = nums[i-1]*nums[k]*nums[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(steps, mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int[] nums = {40, 20, 30, 10, 30};
        System.out.println(mcmRec(nums));
        System.out.println(mcmMemo(nums));
        System.out.println(mcmDP(nums));
    }
}
