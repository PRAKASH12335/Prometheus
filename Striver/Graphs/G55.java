package Striver.Graphs;

// G55. Bridges in Graph – Using Tarjan’s Algorithm of time in and low time
// 1192. Critical Connections in a Network

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G55 {
    int timer = 1;

    public void dfs(int node, int parent, List<List<Integer>> adjList, boolean[] vis, int[] tin, int[] low, List<List<Integer>> bridges){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int it : adjList.get(node)){
            if(it == parent) continue;
            if(vis[it] == false){
                dfs(it, node, adjList, vis, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        List<List<Integer>> bridges = new ArrayList<>();
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        dfs(0, -1, adjList, vis, tin, low, bridges);
        return bridges;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }
        G55 obj = new G55();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);
        System.out.println(bridges);
    }
}

// Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm is just a simple DFS traversal.
// Space Complexity: O(V+2E) + O(3V),