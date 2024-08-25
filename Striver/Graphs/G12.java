package Striver.Graphs;

import java.util.ArrayList;
import java.util.List;

public class G12 {

    public static boolean dfs(int node, int parent, List<List<Integer>> adjList, boolean[] vis){
        vis[node] = true;
        for(int it : adjList.get(node)){
            if(vis[it] == false){
                if(dfs(it, node, adjList, vis) == true)
                    return true;
            }else if(parent != it)
                return true;
        }
        return false;
    }
    public static boolean detectCycleDFS(List<List<Integer>> adjList, int V){
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(dfs(i, -1, adjList, vis))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 7;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(0);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(1).add(4);
        adjList.get(4).add(1);
        adjList.get(2).add(5);
        adjList.get(5).add(2);
        adjList.get(4).add(6);
        adjList.get(6).add(4);
        adjList.get(5).add(6);
        adjList.get(6).add(5);
        System.out.println(detectCycleDFS(adjList, n));
    }
}

// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.
// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visited array.