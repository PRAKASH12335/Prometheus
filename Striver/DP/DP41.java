package Striver.DP;

// DP 41. Longest Increasing Subsequence
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP41 {

    // Recursion
    public static int lengthOfLISRecHelper(int[] nums, int ind, int prevInd) {
        if(ind == nums.length)
            return 0;
        // not taking number
        int ans = lengthOfLISRecHelper(nums, ind+1, prevInd);;
        if(prevInd == -1 || nums[ind] > nums[prevInd]){
            ans = Math.max(ans, 1 + lengthOfLISRecHelper(nums, ind+1, ind));
        }
        return ans;
    }

    public static int lengthOfLISRec(int[] nums) {
        return lengthOfLISRecHelper(nums, 0, -1);
    }


    // Memoization
    public static int lengthOfLISMemoHelper(int[] nums, int ind, int prevInd, int[][] dp) {
        if(ind == nums.length)
            return 0;
        // not taking number
        if(dp[ind][prevInd+1] != -1)
            return dp[ind][ind-prevInd+1];
        int ans = lengthOfLISMemoHelper(nums, ind+1, prevInd, dp);;
        if(prevInd == -1 || nums[ind] > nums[prevInd]){
            ans = Math.max(ans, 1 + lengthOfLISRecHelper(nums, ind+1, ind));
        }
        return dp[ind][prevInd+1] = ans;
    }

    public static int lengthOfLISMemo(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        Arrays.stream(dp).forEach(a ->Arrays.fill(a, -1));
        return lengthOfLISMemoHelper(nums, 0, -1, dp);
    }


    // DP
    public static int lengthOfLISDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int ans = dp[i+1][j+1];
                if(j == -1 || nums[i] > nums[j]){
                    ans = Math.max(ans, 1 + dp[i+1][i+1]);
                }
                dp[i][j+1] = ans;
            }
        }
        return dp[0][0];
    }

    // DP 42. Printing Longest Increasing Subsequence
    // DP
    public static int[] printLISDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // LIS logic
        int[] hash = new int[n];
        for(int i=1;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i] && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }
        // get the count of LIS
        int ans = -1;
        int lastIndex = -1;
        for(int i=0;i<n;i++){
            if(dp[i] > ans){
                ans = dp[i];
                lastIndex = i;
            }
        }

        // Get the elements of LIS
        List<Integer> result = new ArrayList<>();
        while(hash[lastIndex] != lastIndex){
            result.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        result.add(nums[lastIndex]);
        int[] lis = new int[ans];
        for(int i=0;i<ans;i++){
            lis[i] = result.get(ans - i -1);
        }
        return lis;
    }

    public static void main(String[] args) {
        int[] nums = {2,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISRec(nums));
        System.out.println(lengthOfLISMemo(nums));
        System.out.println(lengthOfLISDP(nums));
        int[] result = printLISDP(nums);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }
}
