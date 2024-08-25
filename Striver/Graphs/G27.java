package Striver.Graphs;

// G-27. Shortest Path in Directed Acyclic Graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}


public class G27 {

    public static void topoDFS(int node, Stack<Integer> st, boolean[] vis, List<List<Pair>>  adjList){
        vis[node] = true;
        for(Pair it : adjList.get(node)){
            int temp = it.node;
            if(vis[temp] == false){
                topoDFS(temp, st, vis, adjList);
            }
        }
        st.push(node);
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        boolean vis[] = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++){
            if(vis[i] == false){
                topoDFS(i, st, vis, adjList);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(Pair it : adjList.get(node)){
                int temp = it.node;
                int weight = it.weight;
                if(dist[node] + weight < dist[temp]){
                    dist[temp] = dist[node] + weight;
                }
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edges ={{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int[] dist = shortestPath(n, m, edges);
        Arrays.stream(dist).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation of vertices, each node and its adjacent nodes get traversed} ~ O(N+M).
// Where N= number of vertices and M= number of edges.
// Space Complexity:  O( N) {for the stack storing the topological sort} + O(N) {for storing the shortest distance for each node} + O(N) {for the visited array} + O( N+2M) {for the adjacency list} ~ O(N+M) .