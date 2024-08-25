package Stack.Medium;

// 1963. Minimum Number of Swaps to Make the String Balanced

import java.util.Stack;

public class L1963 {

    public static int minSwapsStack(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '['){
                st.push(c);
            }else{
                if(!st.isEmpty() && st.peek() == '['){
                    st.pop();
                }else {
                    st.push(c);
                }
            }
        }
        int unbalanced = st.size()/2;
        return (unbalanced+1)/2;
    }

    public static int minSwaps(String s) {
        int open = 0, unbalanced = 0;
        for(char c : s.toCharArray()){
            if(c == '['){
                open++;
            }else{
                if(open > 0){
                    open--;
                }else {
                    unbalanced++;
                }
            }
        }
        return (unbalanced+1)/2;
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
        System.out.println(minSwapsStack(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)