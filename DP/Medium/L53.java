package DP.Medium;

public class L53 {

    // DP
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], maxSoFar = nums[0];
        for(int i=1;i<nums.length;i++){
            maxSoFar = Math.max(nums[i], nums[i]+maxSoFar);
            maxSum = Math.max(maxSum, maxSoFar);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}

// Time Complexity - O(n)
// Space Complexity - 0(1)