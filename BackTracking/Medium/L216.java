package BackTracking.Medium;

// 216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class L216 {

    public static void helper(List<List<Integer>> ans, List<Integer> temp, int start, int k, int n){
        if(temp.size() == k && n == 0){
            ans.add(new ArrayList<>(temp));
        }
        for(int i=start;i<=9;i++){
            temp.add(i);
            helper(ans, temp, i+1, k, n-i);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(combinationSum3(k, n));
    }
}

// Time Complexity - O(9^k)
// Space Complexity - O(n)