package Stack.Hard;

// 227. Basic Calculator II

import java.util.Stack;

public class L227 {
    public static int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int currNumber = 0;
        Stack<Integer> st = new Stack<>();
        char operation = '+';

        for(int i=0;i<len;i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                currNumber = (currNumber * 10) + (currChar-'0');
            }
            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i==len-1){
                if(operation == '+'){
                    st.push(currNumber);
                }else if(operation == '-'){
                    st.push(-currNumber);
                }else if(operation == '*'){
                    st.push(st.pop() * currNumber);
                }else if(operation == '/'){
                    st.push(st.pop() / currNumber);
                }
                operation = currChar;
                currNumber = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return  result;
    }

    public static void main(String[] args) {
        String s = "3-2*2*2";
        System.out.println(calculate(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)