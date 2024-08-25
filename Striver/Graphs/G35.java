package Striver.Graphs;

// G-35. Print Shortest Path - Dijkstra's Algorithm

import java.util.*;

public class G35 {

    public static List<Integer> dijkstraShortestPath(int V, int[][] edges, int src, int dest){
        List<List<NodeDist>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new NodeDist(edge[1], edge[2]));
            adjList.get(edge[1]).add(new NodeDist(edge[0], edge[2]));
        }
        int[] dist = new int[V];
        int[] parent = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        PriorityQueue<NodeDist> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist[src] = 0;
        pq.add(new NodeDist(src, 0));
        while(!pq.isEmpty()){
            NodeDist nd = pq.poll();
            int node = nd.node;
            int dis = nd.dist;
            for(NodeDist it : adjList.get(node)){
                int newNode = it.node;
                int newDist = it.dist;
                if(dis + newDist < dist[newNode]){
                    dist[newNode] = dis + newDist;
                    pq.add(new NodeDist(newNode, dist[newNode]));
                    parent[newNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[dest] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node = dest;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        G35 obj = new G35();
        int V = 6, src = 1, dest = 5;
        int[][] edges = {{0,1,4}, {0,2,4}, {1,2,2}, {2,3,3}, {2,4,1}, {2,5,6}, {3,5,2}, {4,5,3}};
        List<Integer> res= obj.dijkstraShortestPath(V, edges, src, dest);
        System.out.println(res);
    }
}
