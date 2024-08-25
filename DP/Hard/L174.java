package DP.Hard;

// 174. Dungeon Game

import java.util.Arrays;

public class L174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int princess = dungeon[m-1][n-1];
        dp[m-1][n-1] = princess < 0 ? -1*princess+1 : 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1)
                    continue;
                int health = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                if(dungeon[i][j] >= dp[i+1][j] || dungeon[i][j] >= dp[i][j+1])
                    health = 1;
                dp[i][j] = health;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        L174 obj = new L174();
        System.out.println(obj.calculateMinimumHP(dungeon));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)