package BackTracking.Medium;

// 46. Permutations

import java.util.ArrayList;
import java.util.List;

public class L46 {

    public static void permuteUtil1(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] map){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!map[i]) {
                ds.add(nums[i]);
                map[i] = true;
                permuteUtil1(nums, ans, ds, map);
                ds.remove(ds.size()-1);
                map[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        permuteUtil1(nums, ans, ds, map);
        return ans;
    }

    public static void permuteUtil2(int index, int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i< nums.length;i++){
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i, index, nums);
            permuteUtil2(index+1, nums, ans);
            swap(i, index, nums);
        }
    }

    public static void swap(int i, int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteUtil2(0, nums, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute1(nums));
        System.out.println(permute2(nums));
    }
}

// Time Complexity - O(n*n!)
// Space Complexity - O(n)