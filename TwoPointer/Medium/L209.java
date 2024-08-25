package TwoPointer.Medium;

// 209. Minimum Size Subarray Sum
// 713. Subarray Product Less Than K
// 560. Subarray Sum Equals K
// 974. Subarray Sums Divisible by K
// 523. Continuous Subarray Sum
// 992. Subarrays with K Different Integers

public class L209 {
    public static int minSizeSubarraySum(int[] nums, int target) {
        int n = nums.length;
        int sum = 0, start = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum += nums[i];
            while(sum >= target){
                minLength = Math.min(minLength, i-start+1);
                sum = sum - nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSizeSubarraySum(nums, target));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)