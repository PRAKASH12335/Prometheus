package Striver.DP;

import java.util.Arrays;

public class DP3 {

    // Recursion
    public static int frogJumpRecHelper(int index, int[] arr){
        if(index == 0)
            return 0;
        int step1 = Math.abs(arr[index] - arr[index-1]) + frogJumpRecHelper(index-1, arr);
        int step2 = Integer.MAX_VALUE;
        if(index > 1) {
            step2 = Math.abs(arr[index] - arr[index - 2]) + frogJumpRecHelper(index - 2, arr);
        }
        return Math.min(step1, step2);
    }
    public static int frogJumpRec(int[] arr){
        return frogJumpRecHelper(arr.length-1, arr);
    }

    // Memo
    public static int frogJumpMemoHelper(int index, int[] arr, int[] dp){
        if(index == 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        int step1 = Math.abs(arr[index] - arr[index-1]) + frogJumpMemoHelper(index-1, arr, dp);
        int step2 = Integer.MAX_VALUE;
        if(index > 1) {
            step2 = Math.abs(arr[index] - arr[index - 2]) + frogJumpMemoHelper(index - 2, arr, dp);
        }
        return dp[index] = Math.min(step1, step2);
    }
    public static int frogJumpMemo(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return frogJumpMemoHelper(arr.length-1, arr, dp);
    }

    // DP
    public static int frogJumpDP(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=2;i<n;i++){
            int fs = Math.abs(arr[i]-arr[i-1]) + dp[i-1];
            int ss = Integer.MAX_VALUE;
            if(i > 1)
                ss = Math.abs(arr[i]-arr[i-2]) + dp[i-2];
            dp[i] = Math.min(fs, ss);
        }
        return dp[n-1];
    }

    // DP Space optimized
    public static int frogJumpDPSpace(int[] arr){
        int n = arr.length;
        int prev2 = 0;
        int prev1 = 0;
        for(int i=2;i<n;i++){
            int fs = Math.abs(arr[i]-arr[i-1]) + prev1;
            int ss = Integer.MAX_VALUE;
            if(i > 1)
                ss = Math.abs(arr[i]-arr[i-2]) + prev2;
            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] energy = new int[]{30,10,60,10,60,50};
        System.out.println(frogJumpRec(energy));
        System.out.println(frogJumpMemo(energy));
        System.out.println(frogJumpDP(energy));
        System.out.println(frogJumpDPSpace(energy));
    }
}

// Time Complexity: O(N)
// We are running a simple iterative loop
// Space Complexity: O(1)
// Reason: We are not using any extra space.