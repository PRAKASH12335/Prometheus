package Stack.Easy;

import java.util.Stack;

// 1047. Remove All Adjacent Duplicates in String

public class L1047 {

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
            }else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)