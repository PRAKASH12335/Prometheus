package Striver.Graphs;

// G-47. Kruskal's Algorithm - Minimum Spanning Tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    @Override
    public int compareTo(Edge compareEdge){
        return this.wt - compareEdge.wt;
    }
}

public class G47 {

    public int spanningTree(int V, int[][] edges){
        List<List<NodeDist>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new NodeDist(edge[1], edge[2]));
//            adjList.get(edge[1]).add(new NodeDist(edge[0], edge[2]));
        }

        List<Edge> edgeList = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(NodeDist it : adjList.get(i)){
                int node = i;
                int adjNode = it.node;
                int wt = it.dist;
                Edge e = new Edge(node, adjNode, wt);
                edgeList.add(e);
            }
        }
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edgeList);
        int mstWt = 0;
        for(int i=0;i<edgeList.size();i++){
            int u = edgeList.get(i).src;
            int v = edgeList.get(i).dest;
            int wt = edgeList.get(i).wt;
            if(ds.findParent(u) != ds.findParent(v)){
                mstWt += wt;
                ds.unionByRank(u, v);
            }
        }
        return mstWt;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        G47 obj = new G47();
        int mstWt = obj.spanningTree(V, edges);
        System.out.println(mstWt);
    }
}

// Time Complexity: O(N+E) + O(E logE) + O(E*4α*2)   where N = no. of nodes and E = no. of edges. O(N+E) for extracting edge information from the adjacency list.
// O(E logE) for sorting the array consists of the edge tuples.
// Space Complexity: O(N) + O(N) + O(E) where E = no. of edges and N = no. of nodes.