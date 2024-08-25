package Graphs.Medium;

// 778. Swim in Rising Water

import java.util.PriorityQueue;

class Water{
    int x;
    int y;
    int time;

    public Water(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class L778 {

    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Water> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Water(0, 0, grid[0][0]));
        int[] dirX = {1,0,0,-1};
        int[] dirY = {0,1,-1,0};

        while(!pq.isEmpty()){
            Water p = pq.poll();
            int x = p.x;
            int y = p.y;
            int cost = p.time;
            if(x == m-1 && y == n-1)
                return cost;
            if(visited[x][y] == true)
                continue;
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && visited[nx][ny] == false){
                    pq.add(new Water(nx, ny, Math.max(grid[nx][ny], cost)));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        L778 obj = new L778();
        System.out.println(obj.swimInWater(grid));
    }
}

