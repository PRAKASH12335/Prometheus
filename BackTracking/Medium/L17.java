package BackTracking.Medium;

// 17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L17 {

    public static void helper(String digits, HashMap<Integer, String> hmap, List<String> ans, StringBuilder sb, int index){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        for(int i=index;i<digits.length();i++){
            String mappedString = hmap.get(Integer.valueOf(String.valueOf(digits.charAt(i))));
            for(int j=0;j<mappedString.length();j++){
                sb.append(mappedString.charAt(j));
                helper(digits, hmap, ans, sb, i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(2, "abc");
        hmap.put(3, "def");
        hmap.put(4, "ghi");
        hmap.put(5, "jkl");
        hmap.put(6, "mno");
        hmap.put(7, "pqrs");
        hmap.put(8, "tuv");
        hmap.put(9, "wqyz");
        helper(digits, hmap, ans, new StringBuilder(), 0);
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}

// Time complexity - O(3^N)
// Space complexity - O(N) + O(3^N) for recursion