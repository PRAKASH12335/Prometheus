package Graphs.Medium;

// 329. Longest Increasing Path in a Matrix

public class L329 {

    public int dfs(int r, int c, int[][] matrix, int[][] memo){
        if(memo[r][c] > 0)
            return memo[r][c];

        int[] dirX = {1,0,0,-1};
        int[] dirY = {0,1,-1,0};
        int ans = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<4;i++){
            int nx = r + dirX[i];
            int ny = c + dirY[i];
            if(nx < 0 || ny < 0 || nx >= row || ny >= col)
                continue;
            if(matrix[nx][ny] <= matrix[r][c])
                continue;
            ans = Math.max(ans, dfs(nx, ny, matrix, memo) + 1);
        }
        return memo[r][c] = ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 1 && col == 1)
            return 1;
        int max = 0;
        int[][] memo = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(memo[i][j] == 0){
                    max = Math.max(max, dfs(i, j, matrix, memo));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        L329 obj = new L329();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(obj.longestIncreasingPath(matrix));
    }
}

// Time complexity - O(M*N)
// Space complexity - O(M*N)