package TwoPointer.Medium;

// 1493. Longest Subarray of 1's After Deleting One Element

//Given a binary array nums, you should delete one element from it.
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
//Example 1:
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

public class L1493 {
    public static int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int start = 0;
        int longestWindow = 0;
        for(int i=0;i<nums.length;i++){
            zeroCount += nums[i] == 0 ? 1 : 0;
            while(zeroCount>1){
                zeroCount -= nums[start] == 0 ? 1 : 0;
                start++;
            }
            longestWindow = Math.max(longestWindow, i-start);
        }
        return longestWindow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)