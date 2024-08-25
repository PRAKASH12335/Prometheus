package Graphs.Medium;

// 417. Pacific Atlantic Water Flow

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L417 {

    private void dfs(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col])
            return;
        visited[row][col] = true;
        dfs(row+1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row-1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col+1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col-1, rows, cols, visited, heights[row][col], heights);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int row=0;row<rows;row++){
            dfs(row, 0, rows, cols, pac, heights[row][0], heights);
            dfs(row, cols-1, rows, cols, atl, heights[row][cols-1], heights);
        }

        for(int col=0;col<cols;col++){
            dfs(0, col, rows, cols, pac, heights[0][col], heights);
            dfs(rows-1, col, rows, cols, atl, heights[rows-1][0], heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int row=0;row< rows;row++){
            for(int col=0;col<cols;col++){
                if(pac[row][col] && atl[row][col])
                    result.add(Arrays.asList(row, col));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        L417 obj = new L417();
        System.out.println(obj.pacificAtlantic(heights));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)