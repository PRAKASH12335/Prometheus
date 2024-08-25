package Graphs.Medium;

import java.util.*;

// 802. Find Eventual Safe States

public class L802 {

    //BFS
    public static List<Integer> eventualSafeNodesBFS(List<List<Integer>> adjList, int n) {
        int[] indegree = new int[n];
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<n;i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            // i -> it
            // it -> i
            for(int it : adjList.get(i)){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : revAdj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
// Time Complexity: O(V+E)+O(N*logN), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm. Extra O(N*logN) for sorting the safeNodes array, where N is the number of safe nodes.
// Space Complexity: O(N) + O(N) + O(N) ~ O(3N), O(N) for the indegree array, O(N) for the queue data structure used in BFS(where N = no.of nodes), and extra O(N) for the adjacency list to store the graph in a reversed order.

    // DFS
    public static boolean isCycleDFS(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adjList, boolean[] check){
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        for(int it : adjList.get(node)){
            if(vis[it] == false){
                if(isCycleDFS(it, vis, pathVis, adjList, check) == true){
                    return true;
                }
            }
            else if (pathVis[it] == true){
                return true;
            }
        }
        check[node] = true;
        pathVis[node] = false;
        return false;
    }

    public static List<Integer> eventualSafeNodesDFS(List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                isCycleDFS(i, vis, pathVis, adjList, check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i] == true)
                ans.add(i);
        }
        return ans;
    }
// Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.
// Space Complexity: O(3N) + O(N) ~ O(3N): O(3N) for three arrays required during dfs calls and O(N) for recursive stack space.

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n =12;
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
        adjList.get(11).add(9);

        System.out.println(eventualSafeNodesDFS(adjList));

        System.out.println(eventualSafeNodesBFS(adjList, n));
    }
}
