package Stack.Medium;

// 739. Daily Temperatures

import java.util.Arrays;
import java.util.Stack;

public class L739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        if(n==0) return result;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty())
                result[i] = 0;
            else
                result[i] = st.peek()-i;
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        Arrays.stream(res).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)