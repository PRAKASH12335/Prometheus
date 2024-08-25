package BackTracking.Medium;

// 22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class L22 {

    public static void helper(List<String> ans, int open, int closed, int n, String temp){
        if(open == n && closed == n){
            ans.add(temp);
            return;
        }
        if(open < n)
            helper(ans, open+1, closed, n, temp+'(');
        if(closed < open)
            helper(ans, open, closed+1, n, temp+')');
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, n, "");
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}

// Time complexity - O(2^N)
// Space complexity - O(N)