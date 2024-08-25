package BackTracking.Medium;

// 47. Permutations II

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L47 {

    public static void permuteUniqueHelper(int[] nums, List<List<Integer>> ans, Set<List<Integer>> set, int index) {
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            if(!set.contains(temp)){
                ans.add(new ArrayList<>(temp));
                set.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = index;i< nums.length;i++){
            swap(i, index, nums);
            permuteUniqueHelper(nums, ans, set, index+1);
            swap(i, index, nums);
        }
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        permuteUniqueHelper(nums, ans, set, 0);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}

// Time Complexity - O(n*n!)
// Space Complexity - O(n)