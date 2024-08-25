package Graphs.Easy;

// 733. Flood Fill

public class L733 {

    public static void dfs(int[][] image, int r, int c, int oldColor, int newColor){
        if(image[r][c] == oldColor){
            image[r][c] = newColor;
            if(r-1 >= 0) dfs(image, r-1, c, oldColor, newColor);
            if(c-1 >= 0) dfs(image, r, c-1, oldColor, newColor);
            if(r+1 < image.length) dfs(image, r+1, c, oldColor, newColor);
            if(c+1 < image[0].length) dfs(image, r, c+1, oldColor, newColor);
        }
    }

    public static void dfs2(int[][] image, int[][] ans, int r, int c, int oldColor, int newColor){
        ans[r][c] = newColor;
        int m = image.length, n = image[0].length;
        int[] dirX = {-1, 0, 0, 1};
        int[] dirY = {0, 1, -1, 0};
        for(int i=0;i<4;i++){
            int x = r + dirX[i];
            int y = c + dirY[i];
            if(x >=0 && x < m && y >=0 && y < n && image[x][y] == oldColor && ans[x][y] != newColor){
                dfs2(image, ans, x, y, oldColor, newColor);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int[][] ans = image;
//        if(oldColor != newColor)
//            dfs(image, sr, sc, oldColor, newColor);
//        return image;
        dfs2(image, ans, sr, sc, oldColor, newColor);
        return ans;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] result = floodFill(image, sr, sc, color);
        for(int i=0;i< result.length;i++){
            for(int j=0;j< result[0].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity - O(N² + NxMx9), N² for the nested loops, and NxMx9 for the overall DFS of the matrix, that will happen throughout if all the cells are filled with 1.
// Space Complexity - O(N²) for visited array max queue space O(N²), If all are marked as 1 then the maximum queue space will be N².