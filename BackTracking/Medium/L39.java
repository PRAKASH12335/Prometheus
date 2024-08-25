package BackTracking.Medium;

// 39. Combination Sum
// 40. Combination Sum II

import java.util.ArrayList;
import java.util.List;

public class L39 {

    public static void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int start) {
        if(target < 0)
            return;
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i< candidates.length;i++){
            temp.add(candidates[i]);
            helper(candidates, target-candidates[i], ans, temp, i);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, ans, temp, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}

// Time Complexity - O(n.2^n)
// Space Complexity - O(n.2^n)