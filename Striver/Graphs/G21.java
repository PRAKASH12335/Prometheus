package Striver.Graphs;

// G-21. Topological Sort Algorithm | DFS

import java.util.*;

public class G21 {

    // DFS
    public static void dfs(int node, Stack<Integer> st, List<List<Integer>> adjList, boolean[] vis){
        vis[node] = true;
        for(int it : adjList.get(node)){
            if(vis[it] == false){
                dfs(it, st, adjList, vis);
            }
        }
        st.push(node);
    }

    public static List<Integer> topoSortDFS(List<List<Integer>> adjList, int n){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                dfs(i, st, adjList, vis);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }

// Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.
// Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for recursive stack space, where N = no. of nodes.


    //BFS
    public static List<Integer> topoSortBFS(List<List<Integer>> adjList, int n){
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
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            // node is in your topo sort
            // so remove it from the indegree
            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        return ans;
    }

// Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.
// Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 6;
        for(int i=0;i<n;i++){
            adjList.add(new LinkedList<>());
        }
        adjList.get(5).add(0);
        adjList.get(5).add(2);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        List<Integer> ans1 = topoSortDFS(adjList, n);
        ans1.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        List<Integer> ans2 = topoSortBFS(adjList, n);
        ans2.stream().forEach(a -> System.out.print(a + " "));
    }
}