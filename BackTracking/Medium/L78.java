package BackTracking.Medium;

// 78. Subsets
// 90. Subsets II

import java.util.ArrayList;
import java.util.List;

public class L78 {

    public static void subsetsHelper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int startIndex) {
        ans.add(new ArrayList<>(temp));
        for(int index = startIndex;index < nums.length;index++){
            temp.add(nums[index]);
            subsetsHelper(nums, ans, temp, index+1);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsHelper(nums, ans, temp, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}

// Time Complexity - O(n.2^n)
// Space Complexity - O(n.2^n)