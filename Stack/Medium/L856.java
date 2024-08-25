package Stack.Medium;

// 856. Score of Parentheses

import java.util.Stack;

public class L856 {

    public static int scoreOfParentheses(String s) {
        int balanced = 0, ans = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                balanced++;
            }else{
                balanced--;
                if(s.charAt(i-1) == '('){
                    ans += Math.pow(2, balanced);
                }
            }
        }
        return ans;
    }
    public static int scoreOfParenthesesStack(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(')
                st.push(c);
            else{
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                    st.push('1');
                }else{
                    int sum = 0;
                    while(!st.isEmpty() && st.peek() != '('){
                        sum += st.pop()-'0';
                    }
                    st.pop();
                    st.push((char)(2*sum+'0'));
                }
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += (st.pop()-'0');
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(scoreOfParenthesesStack(s));
        System.out.println(scoreOfParentheses(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)