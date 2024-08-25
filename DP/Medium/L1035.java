package DP.Medium;

import java.util.Arrays;

public class L1035 {

    // Recursion
    public static int maxUncrossedLinesRec(int m, int n, int[] nums1, int[] nums2) {
        if(m >= nums1.length || n >= nums2.length)
            return 0;
        if(nums1[m] == nums2[n])
            return maxUncrossedLinesRec(m+1, n+1, nums1,nums2) + 1;
        else
            return Math.max(maxUncrossedLinesRec(m + 1, n, nums1, nums2), maxUncrossedLinesRec(m, n + 1, nums1, nums2));
    }

    // Memoization
    public static int maxUncrossedLinesMemo(int m, int n, int[] nums1, int[] nums2, int[][] dp) {
        if(m >= nums1.length || n >= nums2.length)
            return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(nums1[m] == nums2[n])
            return dp[m][n] = maxUncrossedLinesMemo(m+1, n+1, nums1,nums2, dp) + 1;
        else
            return dp[m][n] = Math.max(maxUncrossedLinesMemo(m + 1, n, nums1, nums2, dp), maxUncrossedLinesMemo(m, n + 1, nums1, nums2,dp));
    }

    // DP
    private static int maxUncrossedLinesDP(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=nums1.length-1;i>=0;i--){
            for(int j=nums2.length-1;j>=0;j--){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] nums1 = {1,4,2}, nums2 = {1,2,4};
        System.out.println(maxUncrossedLinesRec(0, 0, nums1, nums2));
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(maxUncrossedLinesMemo(0, 0, nums1, nums2, dp));

        System.out.println(maxUncrossedLinesDP(nums1, nums2));
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)