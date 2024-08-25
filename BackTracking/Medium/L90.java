package BackTracking.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90. Subsets II

public class L90 {

    public static void subsetsHelper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int startIndex) {
        ans.add(new ArrayList<>(temp));
        for(int index = startIndex;index < nums.length;index++){
            if(index > startIndex && nums[index] == nums[index-1])
                continue;
            temp.add(nums[index]);
            subsetsHelper(nums, ans, temp, index+1);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, ans, temp, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3};
        System.out.println(subsetsWithDup(nums));
    }
}

// Time Complexity - O(n.2^n)
// Space Complexity - O(n.2^n)