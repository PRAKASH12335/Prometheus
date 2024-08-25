package Graphs.Medium;

// 1631. Path With Minimum Effort

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1631 {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        Arrays.stream(dist).forEach(a ->Arrays.fill(a, Integer.MAX_VALUE));
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Node(0,0, 0));
        dist[0][0] = 0;
        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};

        while(!pq.isEmpty()){
            Node nd = pq.poll();
            int x = nd.x;
            int y = nd.y;
            int diff = nd.dist;
            if(x == m-1 && y == n-1)
                return diff;
            for(int i=0;i<4;i++){
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if(nx >=0 && nx < m && ny >= 0 && ny < n){
                    int newEffort = Math.max(Math.abs(heights[nx][ny] - heights[x][y]), diff);
                    if(newEffort < dist[nx][ny]){
                        dist[nx][ny] = newEffort;
                        pq.add(new Node(nx, ny, newEffort));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        L1631 obj = new L1631();
        System.out.println(obj.minimumEffortPath(heights));
    }
}

// Time Complexity: O( 4*N*M * log( N*M) ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the minimum effort and additional log(N*M) for insertion-deletion operations in a priority queue }
// Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.
// Space Complexity: O( N*M ) { Distance matrix containing N*M cells + priority queue in the worst case containing all the nodes ( N*M) }.
// Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.