package Misc;

// L10. Subset Sum I

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L10 {

    public static void subsetSumHelper(int[] nums, List<Integer> ans, int index, int sum) {
        if (index == nums.length){
            ans.add(sum);
            return;
        }
        subsetSumHelper(nums, ans, index+1, sum+nums[index]);
        subsetSumHelper(nums, ans, index+1, sum);
    }

    public static List<Integer> subsetSum(int[] nums){
        List<Integer> ans = new ArrayList<>();
        subsetSumHelper(nums, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(subsetSum(nums));
    }
}
