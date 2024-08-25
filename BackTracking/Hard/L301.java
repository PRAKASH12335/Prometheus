package BackTracking.Hard;

// 301. Remove Invalid Parentheses

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class L301 {

    public static int getMinInvalid(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else if (c == ')'){
                if(st.isEmpty())
                    st.push(c);
                else if (st.peek() == ')')
                    st.push(c);
                else if (st.peek() == '(')
                    st.pop();
            }
        }
        return st.size();
    }

    public static void helper(List<String> ans, HashSet<String> set, String s, int minInv){
        if(set.contains(s))
            return;
        set.add(s);
        if(minInv < 0)
            return;
        if(minInv == 0){
            if(getMinInvalid(s) == 0){
                ans.add(s);
                return;
            }
        }
        for(int i=0;i<s.length();i++){
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            helper(ans, set, left+right, minInv-1);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        helper(ans, set, s, getMinInvalid(s));
        return ans;
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(removeInvalidParentheses(s));
    }
}

// Time Complexity - O(2^n)
// Space Complexity - O(n + |ans|)