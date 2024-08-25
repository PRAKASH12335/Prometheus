package BackTracking.Medium;

// 40. Combination Sum II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40 {

    public static void helper(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int start) {
        if(target < 0)
            return ;
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i< nums.length;i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            helper(nums, target-nums[i], ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, temp, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}

// Time Complexity - O(n.2^n)
// Space Complexity - O(n.2^n)