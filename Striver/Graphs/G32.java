package Striver.Graphs;

// G-32. Dijkstra's Algorithm - Using Priority Queue

import java.util.*;

class NodeDist{
    int node;
    int dist;

    NodeDist(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

public class G32 {

    public int[] dijkstra(int V, int[][] edges, int src){
        List<List<NodeDist>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new NodeDist(edge[1], edge[2]));
            adjList.get(edge[1]).add(new NodeDist(edge[0], edge[2]));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<NodeDist> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new NodeDist(src, 0));
        dist[src] = 0;
        while(!pq.isEmpty()){
            NodeDist nd = pq.poll();
            int dis = nd.dist;
            int node = nd.node;
            for(NodeDist it : adjList.get(node)){
                int newNode = it.node;
                int newDist = it.dist;
                if(dis + newDist < dist[newNode]){
                    dist[newNode] = dis + newDist;
                    pq.add(new NodeDist(newNode, dist[newNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        G32 obj = new G32();
        int V = 6, src = 1;
        int[][] edges = {{0,1,4}, {0,2,4}, {1,2,2}, {2,3,3}, {2,4,1}, {2,5,6}, {3,5,2}, {4,5,3}};
        int[] res= obj.dijkstra(V, edges, src);
        Arrays.stream(res).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity: O( E log(V) ), Where E = Number of edges and V = Number of Nodes.
// Space Complexity: O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.