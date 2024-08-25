package Striver.DP;

import java.util.Arrays;

public class DP4 {

    // Recursion
    public static int frogJumpRecHelper(int index, int[] arr, int k){
        if(index == 0)
            return 0;

        int minJump = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(index-i >= 0) {
                int jump = frogJumpRecHelper(index - i, arr, k) + Math.abs(arr[index] - arr[index - i]) ;
                minJump = Math.min(minJump, jump);
            }
        }
        return minJump;
    }

    public static int frogJumpRec(int[] arr, int k){
        return frogJumpRecHelper(arr.length-1, arr, k);
    }

    // Memo
    public static int frogJumpMemoHelper(int index, int[] arr, int k, int[] dp){
        if(index == 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];

        int minJump = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(index-i >= 0) {
                int jump = frogJumpMemoHelper(index - i, arr, k, dp) + Math.abs(arr[index] - arr[index - i]) ;
                minJump = Math.min(minJump, jump);
            }
        }
        return dp[index] = minJump;
    }

    public static int frogJumpMemo(int[] arr, int k){
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return frogJumpMemoHelper(arr.length-1, arr, k, dp);
    }

    public static int frogJumpDP(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int minJump = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]) ;
                    minJump = Math.min(minJump, jump);
                }
            }
            dp[i] = minJump;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] energy = new int[]{30,10,60,10,60,50};
        System.out.println(frogJumpRec(energy, 2));
        System.out.println(frogJumpMemo(energy, 2));
        System.out.println(frogJumpDP(energy, 2));
    }
}

// Time Complexity: O(N*K)
// Reason: We are running two nested loops, where outer loops run from 1 to n-1 and the inner loop runs from 1 to K
// Space Complexity: O(N)
// Reason: We are using an external array of size ‘n’’.