package Stack.Easy;

// 20. Valid Parenthesis

import java.util.HashMap;
import java.util.Stack;

public class L20 {

    public static boolean isValidParenthesis(String s){
        HashMap<Character, Character> hmap = new HashMap<>();
        hmap.put('(', ')');
        hmap.put('{', '}');
        hmap.put('[', ']');
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(hmap.keySet().contains(c)){
                st.push(c);
            }else if(hmap.values().contains(c)){
                if(!st.isEmpty() && hmap.get(st.peek()) == c){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({)}";
        System.out.println(isValidParenthesis(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)