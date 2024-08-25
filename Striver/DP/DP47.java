package Striver.DP;

// 47. Number of Longest Increasing Subsequenses

import java.util.Arrays;

public class DP47 {

    public int countLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxLength = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if(nums[j] < nums[i] && dp[i] == dp[j]+1){
                    count[i] += count[j];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println("maxLength of LIS : "+ maxLength);
        Arrays.stream(dp).forEach(a -> System.out.print( a + " "));
        System.out.println();
        Arrays.stream(count).forEach(a -> System.out.print( a + " "));
        System.out.println();

        int noOfLIS = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxLength){
                noOfLIS += count[i];
            }
        }
        return noOfLIS;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,4,3,2,6,7,2};
        DP47 obj = new DP47();
        System.out.println(obj.countLIS(nums));
    }
}
