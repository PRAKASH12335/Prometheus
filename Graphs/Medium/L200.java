package Graphs.Medium;

// 200. Number of Islands

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class L200 {

    // DFS
    public static int dfs(int row, int col, char[][] grid, int m , int n){
        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0')
            return 0;

        grid[row][col] = '0';
        dfs(row+1, col, grid, m, n);
        dfs(row, col+1, grid, m, n);
        dfs(row, col-1, grid, m, n);
        dfs(row-1, col, grid, m, n);
        return 1;
    }

    public static int numIslandsDFS(char[][] grid) {
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    cnt += dfs(i, j, grid, m, n);
                }
            }
        }
        return cnt;
    }
    // Time complexity - O(M*N)
    // Space complexity - O(1)

    // BFS
    public static void bfs(int row, int col, boolean[][] vis, char[][] grid, int m , int n){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;
        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nrow = x + dirX[i];
                int ncol = y + dirY[i];
                if(nrow >=0 && nrow < m && ncol >=0 && ncol < n && vis[nrow][ncol] == false &&grid[nrow][ncol] == '1'){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }

    public static int numIslandsBFS(char[][] grid) {
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    cnt++;
                    bfs(i, j, vis, grid, m, n);
                }
            }
        }
        return cnt;
    }

    // Time complexity - O(M*N)
    // Space complexity - O(M*N)

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '1', '0', '0', '1'}
        };
        System.out.println(numIslandsBFS(grid));

        System.out.println(numIslandsDFS(grid));
    }
}
