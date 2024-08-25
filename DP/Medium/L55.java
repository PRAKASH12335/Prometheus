package DP.Medium;


// Jump Game

public class L55 {

    public static boolean canJump(int[] nums) {
        int min = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i >= min){
                min = i;
            }
        }
        if(min == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}

// Time Complexity - O(n)
// Space Complexity - 0(1)