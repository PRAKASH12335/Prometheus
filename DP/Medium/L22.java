package DP.Medium;

import java.util.ArrayList;
import java.util.List;

public class L22 {

    public static void generateParenthesisUtil(List<String> result, String temp, int open, int closed, int n){
        if(open == n && closed == n)
            result.add(temp);
        if(open < n)
            generateParenthesisUtil(result, temp +'(', open+1, closed, n);
        if(closed < open)
            generateParenthesisUtil(result, temp +')', open, closed+1, n);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisUtil(result, new String(), 0, 0, n);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }
}

// Time Complexity - O(2^2n)
// Space Complexity - 0(2*n) ~ O(n)