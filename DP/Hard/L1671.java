package DP.Hard;

// 1671. Minimum Number of Removals to Make Mountain Array

import java.util.Arrays;

public class L1671 {

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && dp1[i] < dp1[j]+1){
                    dp1[i] = dp1[j]+1;
                }
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i] > nums[j] && dp2[i] < dp2[j]+1){
                    dp2[i] = dp2[j]+1;
                }
            }
        }

//        int[] result = new int[n];
//        for(int i=0;i<n;i++){
//            if(dp1[i] > 1 && dp2[i] > 1){
//                result[i] = dp1[i]+dp2[i]-1;
//            }
//        }
//        int max = 0;
//        for(int i=0;i<n;i++){
//            max = Math.max(max, result[i]);
//        }
//        return n-max;

        int maxi=0;
        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1)
                maxi = Math.max(maxi, dp1[i]+dp2[i]-1);
        }
        return n-maxi;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,5,6,2,3,1};
        L1671 obj = new L1671();
        System.out.println(obj.minimumMountainRemovals(nums));
    }
}

// Time Complexity - O(n^2)
// Space Complexity - O(n)