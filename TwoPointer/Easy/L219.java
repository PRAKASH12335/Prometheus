package TwoPointer.Easy;

// 219. Contains Duplicate II

import java.util.HashMap;

public class L219 {
    public static boolean containNearbyDuplicates(int[] nums, int k){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int curr = nums[i];
            if(hmap.containsKey(curr) && (i - hmap.get(curr)) <= k)
                return true;
            else
                hmap.put(curr, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k=3;
        System.out.println(containNearbyDuplicates(nums, k));
    }
}


// Time Complexity - O(N)
// Space Complexity - O(N)