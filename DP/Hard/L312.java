package DP.Hard;

// 312. Burst Balloons

import java.util.Arrays;

public class L312 {


    // Recursion
    public int maxCoinsHelper(int i, int j, int[] nums) {
        if(i>j)
            return 0;
        int maxi = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost = nums[i-1]*nums[k]*nums[j+1] + maxCoinsHelper(i, k-1, nums) + maxCoinsHelper(k+1, j, nums);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i=0;i<nums.length;i++){
            newNums[i+1] = nums[i];
        }
        return maxCoinsHelper(1, nums.length, newNums);
    }

    // Time Complexity - O(N^3)
    // Space Complexity - O(N^2)

    // Memoization
    public int maxCoinsMemoHelper(int i, int j, int[] nums, int [][] dp) {
        if(i>j)
            return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j] != -1)
            return dp[i][j];
        for(int k=i;k<=j;k++){
            int cost = nums[i-1]*nums[k]*nums[j+1] + maxCoinsMemoHelper(i, k-1, nums, dp) + maxCoinsMemoHelper(k+1, j, nums, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoinsMemo(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i=0;i<nums.length;i++){
            newNums[i+1] = nums[i];
        }
        int[][] dp = new int[nums.length+1][nums.length+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return maxCoinsMemoHelper(1, nums.length, newNums, dp);
    }

    public int maxCoinsDP(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for(int i=0;i<n;i++){
            newNums[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = newNums[i-1]*newNums[k]*newNums[j+1] + dp[i][k-1] + dp[k+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    // Time Complexity: O(N3), There are total N2 no. of states. And for each state, we are running a partitioning loop roughly for N times.
    // Space Complexity: O(N2), N2 for the dp array we are using.

    public static void main(String[] args) {
        int[] nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2};
        L312 obj = new L312();
        System.out.println(obj.maxCoins(nums));
        System.out.println(obj.maxCoinsMemo(nums));
        System.out.println(obj.maxCoinsDP(nums));
    }
}
