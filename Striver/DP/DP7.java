package Striver.DP;

//

import java.util.Arrays;

public class DP7 {

    // Recursion
    public static int maxPointsHelper(int index, int[][] tasks, int last){
        if(index == 0){
            int max = 0;
            for(int i=0;i<tasks[0].length;i++){
                if(i!=last){
                    max = Math.max(max, tasks[0][i]);
                }
            }
            return max;
        }
        int max = 0;
        for(int i=0;i<tasks[0].length;i++){
            if(i != last){
                int activity = tasks[index][i] + maxPointsHelper(index-1, tasks, i);
                max = Math.max(max, activity);
            }
        }
        return max;
    }
    public static int maxPoints(int[][] tasks){
        int n = tasks[0].length;
        int m = tasks.length;
        return maxPointsHelper(m-1, tasks, n);
    }

    // Memoization
    public static int maxPointsMemoHelper(int index, int[][] tasks, int last, int[][] dp){
        if(index == 0){
            int max = 0;
            for(int i=0;i<tasks[0].length;i++){
                if(i!=last){
                    max = Math.max(max, tasks[0][i]);
                }
            }
            return max;
        }
        if(dp[index][last] != -1)
            return dp[index][last];
        int max = 0;
        for(int i=0;i<tasks[0].length;i++){
            if(i != last){
                int activity = tasks[index][i] + maxPointsMemoHelper(index-1, tasks, i, dp);
                max = Math.max(max, activity);
            }
        }
        dp[index][last] = max;
        return dp[index][last];
    }

    public static int maxPointsMemo(int[][] tasks){
        int n = tasks[0].length;
        int m = tasks.length;
        int[][] dp = new int[m][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return maxPointsMemoHelper(m-1, tasks, n, dp);
    }


    public static void main(String[] args) {
        int[][] tasks = new int[][]{{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
        System.out.println(maxPoints(tasks));
        System.out.println(maxPointsMemo(tasks));
    }
}
