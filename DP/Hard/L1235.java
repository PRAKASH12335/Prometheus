package DP.Hard;

// 1235. Maximum Profit in Job Scheduling

import java.util.Arrays;

public class L1235 {

    public static int helper(int[][] jobs, int idx, int n, int[] dp){
        if(idx >= n)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        int start = idx+1, end = n-1, nextJobIndex = n+1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(jobs[mid][0] >= jobs[idx][1]){
                nextJobIndex = mid;
                end = mid-1;
            }else
                start = mid+1;
        }
        int skipIt = helper(jobs, idx+1, n, dp);
        int takeIt = jobs[idx][2] + helper(jobs, nextJobIndex, n, dp);
        return dp[idx] = Math.max(skipIt, takeIt);
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for(int i=0;i<n;i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        return helper(jobs, 0, n, dp);
    }

    public static void main(String[] args) {
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        System.out.println(jobScheduling(startTime, endTime, profit));
    }
}


// Time Complexity - O(NlogN)
// Space Complexity - O(N)