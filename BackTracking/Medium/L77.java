package BackTracking.Medium;

// 77. Combinations

import java.util.ArrayList;
import java.util.List;

public class L77 {

    public static void combineHelper(int n , int k, List<List<Integer>> ans, List<Integer> temp, int index){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<=n;i++){
            temp.add(i);
            combineHelper(n, k, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineHelper(n, k, ans, temp, 1);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }
}

// Time Complexity - O(2^n)
// Space Complexity - O(2^n)