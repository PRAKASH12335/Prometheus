package Misc;

// L19. Rat in A Maze | Backtracking

import java.util.ArrayList;
import java.util.List;

public class RatinAMaze {

    public static void solveMaze(int row, int col, int n, String temp, int[][] maze, boolean[][] visited, List<String>  ans, int[] dirX, int[] dirY){
        if(row == n-1 && col == n-1){
            ans.add(temp);
            return;
        }
        String dir = "DLRU";
        for(int i=0;i<4;i++){
            int nrow = row + dirX[i];
            int ncol = col + dirY[i];
            if(nrow >=0 && nrow<n && ncol >=0 && ncol<n && visited[nrow][ncol] == false && maze[nrow][ncol] == 1){
                visited[nrow][ncol] = true;
                solveMaze(nrow, ncol, n, temp+dir.charAt(i), maze, visited, ans, dirX, dirY);
                visited[nrow][ncol] = false;
            }
        }
    }

    public static List<String> findPath(int[][] maze, int n){
        List<String> ans = new ArrayList<>();
        int[] dirX = {+1, 0, 0, -1};
        int[] dirY = {0, -1, +1, 0};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        if(maze[0][0] == 1)
            solveMaze(0, 0, n, "", maze, visited, ans, dirX, dirY);
        return ans;
    }


    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1,0,0,0},
                {1,1,0,0},
                {1,1,0,0},
                {0,1,1,1}
        };
        int n = 4;
        System.out.println(findPath(maze, n));
    }
}


// Time Complexity - O(4^M*N)
// Space Complexity - O(M*N)