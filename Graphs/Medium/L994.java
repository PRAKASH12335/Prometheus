package Graphs.Medium;

// 994. Rotting Oranges

import java.util.LinkedList;
import java.util.Queue;

class Orange{
    int x;
    int y;
    int time;
    Orange(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class L994 {

    // BFS
    public static int rottingOranges(int[][] grid){
        int m = grid.length, n = grid[0].length;
        Queue<Orange> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int cntFresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Orange(i, j, 0));
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};
        int maxTime = 0, cnt = 0;
        while(!q.isEmpty()){
            Orange orange = q.poll();
            int row = orange.x;
            int col = orange.y;
            int time = orange.time;
            maxTime = Math.max(time, orange.time);
            for(int i=0;i<4;i++){
                int nrow = row + dirX[i];
                int ncol = col + dirY[i];
                if(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
                    q.add(new Orange(nrow, ncol, time+1));
                    vis[nrow][ncol] = true;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return maxTime;
    }

    public static void main(String[] args) {
        int[][]  grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(rottingOranges(grid));
    }
}

// Time complexity - O(M*N)
// Space complexity - O(M*N)