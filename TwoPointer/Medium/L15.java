package TwoPointer.Medium;

// 15. 3Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || n < 3)
            return result;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                if (nums[i]+nums[j]+nums[k] > 0)
                    k--;
                else if (nums[i]+nums[j]+nums[k] < 0)
                    j++;
                else{
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        L15 obj = new L15();
        System.out.println(obj.threeSum(nums));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(1)