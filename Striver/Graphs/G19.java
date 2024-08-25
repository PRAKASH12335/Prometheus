package Striver.Graphs;

// G-19. Detect cycle in a directed graph using DFS

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G19 {

    // BFS
    public static boolean detectCycleBFS(List<List<Integer>> adjList, int n){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it : adjList.get(i)){
                indegree[it]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            // node is in your topo sort
            // so remove it from the indegree
            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        if(cnt == n) return false;
        return true;
    }

// Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.
// Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the in-degree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).

    // DFS
    public static boolean isCycleDFS(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adjList){
        vis[node] = true;
        pathVis[node] = true;
        for(int it : adjList.get(node)){
            if(vis[it] == false){
                if(isCycleDFS(it, vis, pathVis, adjList) == true){
                    return true;
                }
            }
            else if (pathVis[it] == true){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }

    public static boolean detectCycleDFS(List<List<Integer>> adjList){
        int n = adjList.size();
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                if(isCycleDFS(i, vis, pathVis, adjList) == true)
                    return true;
            }
        }
        return false;
    }

// Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.
// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 11;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(5).add(6);
        adjList.get(3).add(7);
        adjList.get(7).add(5);
        adjList.get(8).add(2);
        adjList.get(8).add(9);
        adjList.get(9).add(10);
        adjList.get(10).add(8);

        System.out.println(detectCycleDFS(adjList));

        System.out.println(detectCycleBFS(adjList, n));
    }
}