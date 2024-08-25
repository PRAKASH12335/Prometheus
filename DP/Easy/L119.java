package DP.Easy;

import java.util.ArrayList;
import java.util.List;

public class L119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }else{
                    temp.add(result.get(j-1)+result.get(j));
                }
            }
            result = temp;
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        List<Integer> result = getRow(n);
        System.out.println(result);
    }
}

// Time complexity - O(N2)
// Space complexity - O(N)