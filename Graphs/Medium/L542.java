package Graphs.Medium;

// 542. 01 Matrix

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    int dist;
    Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class L542 {

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int row = node.x;
            int col = node.y;
            int dis = node.dist;
            dist[row][col] = dis;
            for(int i=0;i<4;i++){
                int nrow = row + dirX[i];
                int ncol = col + dirY[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == false){
                    queue.add(new Node(nrow, ncol, dis+1));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result = updateMatrix(mat);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time complexity - O(M*N)
// Space complexity - O(M*N)