package Stack.Medium;

// 402. Remove K Digits

import java.util.Stack;

public class L402 {

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        //corner case
        if(n == k) return "0";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        // This is a special edge case --> 1 2 3 4 or 1 1 1 1
        while(k>0){
            st.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        //remove all the 0 at the head
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
}
