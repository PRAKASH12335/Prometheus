package TwoPointer.Easy;

// 1. Two Sum

import java.util.HashMap;

public class L1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int temp = target - nums[i];
            if(hmap.containsKey(temp)){
                res[0] = hmap.get(temp);
                res[1] = i;
                return res;
            }else
                hmap.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] +" "+ res[1]);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)