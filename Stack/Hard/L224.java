package Stack.Hard;

import java.util.Stack;

// 224. Basic Calculator

public class L224 {

    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0, num = 0, sign = 1;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (int) ch-'0';
            }else if (ch == '+'){
                ans += sign*num;
                num = 0;
                sign = 1;
            }else if (ch == '-'){
                ans += sign*num;
                num = 0;
                sign = -1;
            }else if (ch == '('){
                st.push(ans);
                st.push(sign);
                sign = 1;
                ans = 0;
            }else if (ch == ')'){
                ans += sign*num;
                num = 0;
                ans *= st.pop();
                ans += st.pop();
            }
        }
        if(num != 0){
            ans += sign*num;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)-2";
        System.out.println(calculate(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)