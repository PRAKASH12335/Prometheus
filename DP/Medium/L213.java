package DP.Medium;

// 213. House Robber II

public class L213 {

    public static int money(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);

        int prev2 = nums[0];
        int prev1 = Math.max(nums[1], nums[0]);
        for(int i=2;i<nums.length;i++){
            int curr = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            nums1[i-1] = nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            nums2[i] = nums[i];
        }
        return Math.max(money(nums1), money(nums2));
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)