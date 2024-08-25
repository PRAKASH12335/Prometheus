package Striver.Graphs;

// G-45. Prim's Algorithm - Minimum Spanning Tree

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class G45 {

    public int minimumSpanningTree(int V, int[][] edges){
        List<List<NodeDist>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new NodeDist(v, wt));
            adjList.get(v).add(new NodeDist(u, wt));
        }

        PriorityQueue<NodeDist> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        boolean[] vis = new boolean[V];
        pq.add(new NodeDist(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            NodeDist nd = pq.poll();
            int node = nd.node;
            int dis = nd.dist;
            if(vis[node] == true) continue;
            vis[node] = true;
            sum += dis;
            for(NodeDist it : adjList.get(node)){
                int adjNode = it.node;
                int adjDist = it.dist;
                if(vis[adjNode] == false){
                    pq.add(new NodeDist(adjNode, adjDist));
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        G45 obj = new G45();
        System.out.println(obj.minimumSpanningTree(V, edges));
    }
}

// Time Complexity: O(E*logE) + O(E*logE)~ O(E*logE), where E = no. of given edges.
// Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices.