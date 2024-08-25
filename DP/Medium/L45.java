package DP.Medium;

import java.util.Arrays;

// Jump Game 2

public class L45 {

    // DP
    public static int jumpDP(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i=1;i<nums.length;i++){
            for(int j =0;j<i;j++){
                if(j+nums[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[nums.length-1];
    }

    // Time Complexity - O(N*N)
    // Space Complexity - O(N)

    // Greedy Algo.
    public static int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int jumps = 0;
        int current = 0;

        for(int i=0;i<n-1;i++){
            farthest = Math.max(farthest, nums[i]+i);
            if(i == current){
                current = farthest;
                jumps++;
            }
        }
        return jumps;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
        System.out.println(jumpDP(nums));
    }
}
