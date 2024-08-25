package Striver.DP;


// DP 18. Count Partitions With Given Difference

import java.util.Arrays;

public class DP18 {

    // Memoization
    static int countSubsetWithtargetRec(int ind, int target, int[] nums,  int[][] dp){
        if(ind == 0){
            if(target==0 && nums[0]==0)
                return 2;
            if(target==0 || target == nums[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];
        int notTaken = countSubsetWithtargetRec(ind-1,target,nums,dp);
        int taken = 0;
        if(nums[ind]<=target)
            taken = countSubsetWithtargetRec(ind-1,target-nums[ind],nums,dp);

        return dp[ind][target]= notTaken + taken;
    }

    static int countSubsets(int target, int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return countSubsetWithtargetRec(n-1, target, nums, dp);
    }


    static int mod =(int)(Math.pow(10,9)+7);
    static int countSubsetWithtarget(int[] num, int target){
        int n = num.length;
        int dp[][] = new int[n][target+1];

        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=target) dp[0][num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            for(int j= 0; j<=target; j++){

                int notTaken = dp[ind-1][j];

                int taken = 0;
                if(num[ind]<=j)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][target];
    }

    public static int countSubsetWithDiff(int[] nums, int diff){
        // s1+s2 = sum
        // s1-s2 = diff
        // s1 = diff+s2
        // diff+s2+s2 = sum
        // s2 = (sum - diff)/2
        int sum = Arrays.stream(nums).sum();
        if(sum - diff < 0 || (sum - diff) % 2 == 1)
            return 0;
        System.out.println("target : "+ (sum - diff)/2);
        // return countSubsetWithtarget(nums, (sum - diff)/2);
        return countSubsets((sum - diff)/2, nums);
    }


    public static void main(String args[]) {

        int arr[] = {5,2,6,4};
        int diff=3;
        System.out.println("The number of subsets found are "+countSubsetWithDiff(arr, diff));
    }
}
