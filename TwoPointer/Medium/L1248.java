package TwoPointer.Medium;

// 1248. Count Number of Nice Subarrays

import java.util.HashMap;

public class L1248 {

    private int numberOfSubarraysAtmostK(int[] nums, int k){
        if(k < 0) return 0;
        int left = 0, right = 0, n = nums.length, sum = 0, cnt = 0;
        while(right < n){
            sum += nums[right]%2;
            while(sum > k){
                sum -= nums[left]%2;
                left++;
            }
            cnt = cnt + right-left+1;
            right++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysAtmostK(nums, k) - numberOfSubarraysAtmostK(nums, k-1);
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        L1248 obj = new L1248();
        System.out.print(obj.numberOfSubarrays(nums, k));
    }

}
