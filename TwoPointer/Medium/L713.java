package TwoPointer.Medium;

// 713. Subarray Product Less Than K
//Given an array of integers nums and an integer k.
//return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

public class L713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)
            return 0;
        int product = 1;
        int start = 0, end = 0, count = 0;
        while(end < nums.length){
            product *= nums[end];
            while(start<nums.length && product>=k){
                product /= nums[start];
                start++;
            }
            if(product<k)
                count += end - start + 1;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)
