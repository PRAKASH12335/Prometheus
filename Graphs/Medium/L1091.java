package Graphs.Medium;

// Shortest Distance in a Binary Maze
// 1091. Shortest Path in Binary Matrix

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L1091 {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid.length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        if(grid[0][0] == 0 && m == 1 && n == 1)
            return 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        int[][] dist = new int[m][n];
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        int[] dirX = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] dirY = {1, 0, -1, -1, -1, 0, 1, 1};
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int dis = node.dist;
            for(int i=0;i<8;i++){
                int r = x + dirX[i];
                int c = y + dirY[i];
                if(r >=0 && r < m && c >=0 && c < n && dist[r][c] > dis + 1 && grid[r][c] == 0){
                    if(r == m-1 && c == n-1)
                        return dis + 1;
                    dist[r][c] = dis + 1;
                    q.add(new Node(r, c, dis + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}

// Time Complexity - O(M*N*8)
// Space Complexity - O(M*N)
