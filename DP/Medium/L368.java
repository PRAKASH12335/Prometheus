package DP.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//368. Largest Divisible Subset

public class L368 {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        for(int i=1;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }
        }

        int max = -1;
        int lastIndex = -1;
        for(int i=0;i<n;i++){
            if(max < dp[i]){
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }

        List<Integer> revAns = new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--){
            revAns.add(ans.get(i));
        }
        return revAns;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,8};
        System.out.println(largestDivisibleSubset(nums));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N)