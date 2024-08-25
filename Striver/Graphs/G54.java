package Striver.Graphs;

// G-54. Strongly Connected Components - Kosaraju's Algorithm

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class G54 {

    public void dfs(int node, boolean[] vis, List<List<Integer>> adjList, Stack<Integer> st){
        vis[node] = true;
        for(int it : adjList.get(node)){
            if(vis[it] == false){
                dfs(it, vis, adjList, st);
            }
        }
        st.push(node);
    }

    public void dfs3(int node, boolean[] vis, List<List<Integer>> revAdjList){
        vis[node] = true;
        for(int it : revAdjList.get(node)){
            if(vis[it] == false){
                dfs3(it, vis, revAdjList);
            }
        }
    }

    public int kosarajuAlgo(int V, List<List<Integer>> adjList){
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                dfs(i, vis, adjList, st);
            }
        }

        List<List<Integer>> revAdjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            for(int it : adjList.get(i)){
                // i -> it
                // it -> i
                revAdjList.get(it).add(i);
            }
        }

        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == false) {
                scc++;
                dfs3(node, vis, revAdjList);
            }
        }
        return scc;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}};
        G54 obj = new G54();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = obj.kosarajuAlgo(V, adjList);
        System.out.println(ans);
    }
}
