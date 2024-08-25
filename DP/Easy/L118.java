package DP.Easy;

import java.util.ArrayList;
import java.util.List;

public class L118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }else{
                    temp.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> result = generate(n);
        System.out.println(result);
    }
}

// Time complexity - O(N2)
// Space complexity - O(N)