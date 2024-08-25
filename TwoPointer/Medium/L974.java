package TwoPointer.Medium;

import java.util.HashMap;

// 974. Subarray Sums Divisible by K

public class L974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int remainder = (sum%k+k)%k;
            if(hmap.containsKey(remainder))
                count += hmap.get(remainder);
            hmap.put(remainder, hmap.getOrDefault(remainder, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        L974 obj = new L974();
        System.out.println(obj.subarraysDivByK(nums, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)