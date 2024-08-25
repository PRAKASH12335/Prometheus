package Graphs.Medium;

// 694. Number of Distinct Islands

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L694 {
    public static String toString(int r, int c){
        return String.valueOf(r)+String.valueOf(c);
    }

    public static void dfs(int row, int col, List<String> pairs, int[][] grid, boolean[][] vis, HashSet<List<String>> hset, int row0, int col0){
        vis[row][col] = true;
        pairs.add(toString(row-row0, col - col0));
        int m = grid.length, n = grid[0].length;
        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};
        for(int i=0;i<4;i++){
            int nrow = row + dirX[i];
            int ncol = row + dirY[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == false){
                dfs(nrow, ncol, pairs, grid, vis, hset, row0, col0);
            }
        }
    }

    public static int numDistIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        HashSet<List<String>> hset = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == false && grid[i][j] == 1) {
                    List<String> pairs = new ArrayList<>();
                    dfs(i, j, pairs, grid, vis, hset, i, j);
                    hset.add(pairs);
                }
            }
        }
        return hset.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,0}
        };
        System.out.println(numDistIslands(grid));
    }
}

// Time Complexity - O(M*N)
// Time Complexity - O(M*N)