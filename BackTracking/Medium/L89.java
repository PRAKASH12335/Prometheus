package BackTracking.Medium;

import java.util.ArrayList;
import java.util.List;

// 89. Gray Code

public class L89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if(n == 0){
            ans.add(0);
            return ans;
        }
        if(n == 1){
            ans.add(0);
            ans.add(1);
            return ans;
        }
        for(int i=0;i<=Math.pow(2, n);i++){
            ans.add(i^(i>>1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(grayCode(n));
    }
}


// Time Complexity - O(2^n)
// Space Complexity - O(2^n)