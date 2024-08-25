package TwoPointer.Medium;

// 560. Subarray Sum Equals K

import java.util.HashMap;

public class L560 {
    public int subarraySum(int[] nums, int k) {
        int sum=0, count=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hmap.containsKey(sum-k)){
                count += hmap.get(sum-k);
            }
//            if(hmap.containsKey(sum)){
//                hmap.put(sum, hmap.get(sum)+1);
//            }else
//                hmap.put(sum,1);
            hmap.put(sum, hmap.getOrDefault(sum, 0)+1);


//            preSum += arr[i];
//
//            // Calculate x-k:
//            int remove = preSum - k;
//
//            // Add the number of subarrays to be removed:
//            cnt += mpp.getOrDefault(remove, 0);
//
//            // Update the count of prefix sum
//            // in the map.
//            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        L560 obj = new L560();
        System.out.println(obj.subarraySum(nums, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)