package DP.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L120 {

    // Recursion
    public static int minimumTotalRec(List<List<Integer>> triangle) {
        return minimumTotalHelper(triangle, 0, 0);
    }

    public static int minimumTotalHelper(List<List<Integer>> triangle, int i, int row) {
        if(row >= triangle.size() || i >= triangle.get(row).size())
            return 0;
        int choice1 = minimumTotalHelper(triangle, i+1, row+1);
        int choice2 = minimumTotalHelper(triangle, i, row+1);
        return Math.min(choice1, choice2) + triangle.get(row).get(i);
    }
    //  Time Complexity - O(2^(1+2+3... n))

    // Memoization
    public static int minimumTotalMemo(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        return minimumTotalMemoHelper(triangle, 0, 0, dp);
    }

    public static int minimumTotalMemoHelper(List<List<Integer>> triangle, int i, int row, int[][] dp) {
        if(row >= triangle.size() || i >= triangle.get(row).size())
            return 0;
        if(dp[row][i] != Integer.MAX_VALUE)
            return dp[row][i];
        int choice1 = minimumTotalMemoHelper(triangle, i+1, row+1, dp);
        int choice2 = minimumTotalMemoHelper(triangle, i, row+1, dp);
        return dp[row][i] = Math.min(choice1, choice2) + triangle.get(row).get(i);
    }


    // DP
    public static int minimumTotalDP(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i=0;i<triangle.size();i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle= new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotalRec(triangle));

        System.out.println(minimumTotalMemo(triangle));
        System.out.println(minimumTotalDP(triangle));
    }
}

// Time Complexity - O(n*n)
// Space Complexity - O(n)