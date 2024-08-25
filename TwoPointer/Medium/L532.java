package TwoPointer.Medium;

// 532. K-diff Pairs in an Array

import java.util.HashMap;

public class L532 {

    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        for(int key : hmap.keySet()){
            if(k == 0){
                if(hmap.get(key) >= 2)
                    count++;
            }else{
                if(hmap.containsKey(key+k))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        L532 obj = new L532();
        System.out.println(obj.findPairs(nums, k));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)
