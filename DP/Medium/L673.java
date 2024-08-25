package DP.Medium;

import java.util.Arrays;

//673. Number of Longest Increasing Subsequence

public class L673 {

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }else if (nums[i] > nums[j] && dp[j]+1 == dp[i]){
                    cnt[i] += cnt[j];
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }

        int count = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == max)
                count += cnt[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N)