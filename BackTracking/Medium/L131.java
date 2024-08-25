package BackTracking.Medium;

//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//Example 1:
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]

import java.util.ArrayList;
import java.util.List;

public class L131 {
    private static boolean isPalin(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    private static void partitionHelper(String s, int idx, List<List<String>>  res, List<String> l){
        if(idx == s.length()){
            res.add(new ArrayList<>(l));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(isPalin(s, idx, i)){
                l.add(s.substring(idx, i+1));
                partitionHelper(s, i+1, res, l);
                l.remove(l.size()-1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelper(s, 0, res, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partition(s));
    }
}

// Time Complexity - O(n.2^n)
// Space Complexity - O(n.2^n)