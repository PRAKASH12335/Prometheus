package TwoPointer.Medium;

// 523. Continuous Subarray Sum

import java.util.HashMap;

public class L523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 0);
        int sum  = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hmap.getOrDefault(sum%k, nums.length) < i){
                return true;
            }
            if(!hmap.containsKey(sum%k)){
                hmap.put(sum%k, i+1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        L523 obj = new L523();
        System.out.println(obj.checkSubarraySum(nums, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)