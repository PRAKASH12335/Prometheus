package Striver.Graphs;

// G-6. Depth-First Search (DFS) |  Traversal Technique in Graphs

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Detect Cycle in undirected graph - DFS
// Detect Cycle in directed graph - BFS // DFS use path visited array or BFS using Topo sort
// Find eventual state - BFS // use path visited array or BFS or toposort
// bipartite graph - DFS
// Topo sort - BFS

public class G6 {

    // DFS
    public static void dfsHelper(int node, boolean[] vis, List<Integer> ans, List<List<Integer>> adjList){
        vis[node] = true;
        ans.add(node);
        for(Integer it : adjList.get(node)){
            if(vis[it] == false) {
                dfsHelper(it, vis, ans, adjList);
            }
        }
    }
    public static List<Integer> dfs(int V, List<List<Integer>> adjList){
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        dfsHelper(0, vis, ans, adjList);
        return ans;
    }

    // BFS
    public static List<Integer> bfs(int V, List<List<Integer>> adjList){
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);
            for(Integer it : adjList.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList < > ());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);

// BFS
//        adjList.get(0).add(1);
//        adjList.get(1).add(0);
//        adjList.get(0).add(4);
//        adjList.get(4).add(0);
//        adjList.get(1).add(2);
//        adjList.get(2).add(1);
//        adjList.get(1).add(3);
//        adjList.get(3).add(1);

        List<Integer> list1 = dfs(n, adjList);
        list1.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        List<Integer> list2 = bfs(n, adjList);
        list2.stream().forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
// Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list