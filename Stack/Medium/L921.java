package Stack.Medium;

// 921. Minimum Add to Make Parentheses Valid

import java.util.Stack;

public class L921 {

    // Without Stack
    public static int minAddToMakeValidWithoutStack(String s) {
        int l = 0, r = 0;

        for(Character c : s.toCharArray()){
            if(c == '(')
                l++;
            else{
                if(l==0)
                    r++;
                else
                    l--;
            }
        }
        return l+r;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    // Using Stack
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '(')
                st.push(c);
            else if(!st.isEmpty() && st.peek() == '(' && c == ')')
                st.pop();
            else if(c == ')')
                st.push(c);
        }
        return st.size();
    }

    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
        System.out.println(minAddToMakeValidWithoutStack(s));
    }
}