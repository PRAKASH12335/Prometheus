package TwoPointer.Medium;

// 1493. Longest Subarray of 1's After Deleting One Element

//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//Example 1:
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

public class L1004 {

    public static int longestOnesStriver(int[] nums, int k) {
        int longestWindow = 0;
        int left = 0;
        int zeroCount = 0;
        int r = 0, n = nums.length;
        while(r < n){
            if(nums[r] == 0)
                zeroCount++;
            if(zeroCount > k){
                if(nums[left] == 0)
                    zeroCount--;
                left++;
            }
            if(zeroCount <= k)
                longestWindow = Math.max(longestWindow, r-left+1);
            r++;
        }
        return longestWindow;
    }
    public static int longestOnes(int[] nums, int k) {
        int longestWindow = 0;
        int start = 0;
        int zeroCount = 0;
        for(int i=0;i<nums.length;i++){
            zeroCount += nums[i] == 0 ? 1 : 0;
            while(zeroCount > k){
                zeroCount -= nums[start] == 0 ? 1 : 0;
                start++;
            }
            longestWindow = Math.max(longestWindow, i-start+1);
        }
        return longestWindow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
        System.out.println(longestOnesStriver(nums, k));
    }
}


// Time complexity - O(N)
// Space complexity - O(1)