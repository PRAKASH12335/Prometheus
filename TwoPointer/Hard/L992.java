package TwoPointer.Hard;

// 992. Subarrays with K Different Integers

import java.util.HashMap;

public class  L992 {

    public int subarrayWithAtmostK(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int subWithAtmostK =  subarrayWithAtmostK(nums, k);
        int reducedSubWithAtmostK =  subarrayWithAtmostK(nums, k-1);
        return subWithAtmostK - reducedSubWithAtmostK;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        int k =3;
        L992 obj = new L992();
        System.out.println(obj.subarraysWithKDistinct(nums, k));
    }
}

// Time Complexity - 0(N)
// Space Complexity - 0(N)