package Striver.Graphs;

// 1976. Number of Ways to Arrive at Destination

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class NodeDistance{
    int node;
    long dist;
    NodeDistance(int node, long dist){
        this.node = node;
        this.dist = dist;
    }
}

public class L1976 {

    public int countPaths(int n, int[][] roads) {
        List<List<NodeDistance>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] road : roads){
            adjList.get(road[0]).add(new NodeDistance(road[1], road[2]));
            adjList.get(road[1]).add(new NodeDistance(road[0], road[2]));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        for(int i=0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new NodeDistance(0, 0));
        long mod = (int)(1e9+7);

        while(!pq.isEmpty()){
            NodeDistance nd = pq.poll();
            int node = nd.node;
            long dis = nd.dist;
            for(NodeDistance adjNode : adjList.get(node)){
                long newDist = adjNode.dist;
                int newNode = adjNode.node;
                if(dis + newDist < dist[newNode]){
                    dist[newNode] = dis + newDist;
                    ways[newNode] = ways[node];
                    pq.add(new NodeDistance(newNode, dis + newDist));
                }else if(dis + newDist == dist[newNode]){
                    ways[newNode] = (ways[newNode] + ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        L1976 obj = new L1976();
        System.out.println(obj.countPaths(n, roads));
    }
}

// Time Complexity: O( E* log(V)) { As we are using simple Dijkstra’s algorithm here, the time complexity will be or the order E*log(V)}
// Where E = Number of edges and V = No. of vertices.
// Space Complexity :  O(N) { for dist array + ways array + approximate complexity for priority queue }
// Where, N = Number of nodes.