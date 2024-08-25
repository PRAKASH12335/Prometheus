package Graphs.Medium;

// 1020. Number of Enclaves

public class L1020 {

    public static void dfs(int row, int col, int[][] grid, boolean[][] vis, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n || vis[row][col] == true || grid[row][col] == 0)
            return;
        vis[row][col] = true;
        dfs(row-1, col, grid, vis, m, n);
        dfs(row, col-1, grid, vis, m, n);
        dfs(row+1, col, grid, vis, m, n);
        dfs(row, col+1, grid, vis, m, n);
    }
    public static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j] == 1 && vis[i][j] == false)
                        dfs(i, j, grid, vis, m, n);
                }
            }
        }

        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && vis[i][j] == false)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}

// Time complexity - O(M*N)
// Space complexity - O(M*N)
