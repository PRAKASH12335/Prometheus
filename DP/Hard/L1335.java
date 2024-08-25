package DP.Hard;

// 1335. Minimum Difficulty of a Job Schedule

import java.util.Arrays;

public class L1335 {

    // Recursion
    private static int rec(int[] array, int start, int d) {
        //base condition
        if(d == 1) {
            int max = 0;
            while(start < array.length) max = Math.max(max, array[start++]);
            return max;
        }
        // recursion  + some extra code to make it work
        int max  = 0;
        int r = Integer.MAX_VALUE;

        for (int i = start; i <= array.length - d; i++) {
            max = Math.max(max, array[i]);
            r = Math.min(r, max + rec(array, i + 1, d - 1));
        }
        return r;
    }

    public static int minDifficultyRec(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length)
            return -1;
        if(d == jobDifficulty.length)
            return Arrays.stream(jobDifficulty).sum();
        return rec(jobDifficulty, 0, d);
    }

    // DP
    public static int helper(int[] jd, int index,  int d, int[][] dp){
        if(d == 1){
            int max = 0;
            while(index < jd.length)
                max = Math.max(max, jd[index++]);
            return max;
        }
        if(dp[index][d] != -1)
            return dp[index][d];
        int max = 0, r = Integer.MAX_VALUE;
        for(int i=index;i <= jd.length-d;i++){
            max = Math.max(max, jd[i]);
            r = Math.min(r, max+helper(jd, i+1, d-1, dp));
        }
        return dp[index][d] = r;
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length)
            return -1;
        if(d == jobDifficulty.length)
            return Arrays.stream(jobDifficulty).sum();
        int[][] dp = new int[jobDifficulty.length+1][d+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(jobDifficulty, 0, d, dp);
    }

    public static void main(String[] args) {
        int[] jobDifficulty = {6,5,4,3,2,1};
        int d = 2;
        System.out.println(minDifficulty(jobDifficulty, d));
        System.out.println(minDifficultyRec(jobDifficulty, d));
    }
}

// Time complexity - O(d*N^2)
// Space complexity - O(d*N)