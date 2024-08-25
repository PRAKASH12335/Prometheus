package Striver.Graphs;

// G-28. Shortest Path in Undirected Graph with Unit Weights

import java.util.*;

public class G28 {

    public int[] shortestPath(int[][] edges, int n, int m ,int src) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adjList.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        G28 obj = new G28();
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int[] dist = obj.shortestPath(edge, n, m, 0);
        for(int i=0;i<n;i++){
            System.out.print(dist[i] + " ");
        }
    }
}


// Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’} + O(N + 2M) { for the BFS Algorithm} + O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M).
// Where N= number of vertices and M= number of edges.
// Space Complexity:  O( N) {for the stack storing the BFS} + O(N) {for the resultant array} + O(N) {for the dist array storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .