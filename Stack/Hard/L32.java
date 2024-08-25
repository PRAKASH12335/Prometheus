package Stack.Hard;

// 32. Longest Valid Parentheses

import java.util.Stack;

public class L32 {

    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(')
                st.push(i);
            else if (ch == ')'){
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else
                    ans = Math.max(ans, i-st.peek());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)
