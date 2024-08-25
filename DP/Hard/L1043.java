package DP.Hard;

// 1043. Partition Array for Maximum Sum

import java.util.Arrays;

public class L1043 {

    // Recursion
    public static int recHelper(int[] arr, int k, int index, int n) {
        if(index == n) return 0;
        int maxAns = Integer.MIN_VALUE;
        int sum = 0, maxi = Integer.MIN_VALUE, len=0;

        for(int i=index;i<Math.min(n, index+k);i++){
            len++;
            maxi = Math.max(maxi, arr[i]);
            sum = len*maxi + recHelper(arr, k, i+1, n);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

    public static int maxSumAfterPartitioningRec(int[] arr, int k) {
        int n = arr.length;
        return recHelper(arr, k, 0, n);
    }

    // Memoization
    public static int memoHelper(int[] arr, int k, int index, int n, int[] dp) {
        if(index == n) return 0;
        int maxAns = Integer.MIN_VALUE;
        int sum = 0, maxi = Integer.MIN_VALUE, len=0;
        if(dp[index] != -1)
            return dp[index];

        for(int i=index;i<Math.min(n, index+k);i++){
            len++;
            maxi = Math.max(maxi, arr[i]);
            sum = len*maxi + memoHelper(arr, k, i+1, n, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[index] = maxAns;
    }

    public static int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoHelper(arr, k, 0, n, dp);
    }


    public static int maxSumAfterPartitioningDP(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int maxAns = Integer.MIN_VALUE;
            int sum = 0, maxi = Integer.MIN_VALUE, len=0;
            for(int j=i;j<Math.min(n, i+k);j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                sum = len*maxi + dp[j+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k =3;
        System.out.println(maxSumAfterPartitioningRec(arr, k));
        System.out.println(maxSumAfterPartitioningMemo(arr, k));
        System.out.println(maxSumAfterPartitioningDP(arr, k));
    }
}

// Time complexity - O(N*k)
// Reason: There are a total of N states and for each state, we are running a loop from 0 to k.
// Space complexity - O(N)