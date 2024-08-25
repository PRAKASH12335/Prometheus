package TwoPointer.Medium;

// 18. 4Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1;j<n-2;j++){
                if(j != i+1 && nums[j] == nums[j-1])
                    continue;
                int k = j+1;
                int l = n-1;
                while(k < l){
                    if(nums[i]+nums[j]+nums[k]+nums[l] < target)
                        k++;
                    else if(nums[i]+nums[j]+nums[k]+nums[l] > target)
                        l--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        l--;
                        k++;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        L18 obj = new L18();
        System.out.println(obj.fourSum(nums, target));
    }
}

// Time Complexity - O(N^3)
// Space Complexity - O(1)