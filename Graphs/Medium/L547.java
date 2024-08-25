package Graphs.Medium;

// Number of Provinces

import java.util.ArrayList;
import java.util.List;

public class L547 {

    public static void dfs(List<List<Integer>> adjList, int node, boolean[] visited){
        visited[node] = true;
        for(int it : adjList.get(node)){
            if(!visited[it])
                dfs(adjList, it, visited);
        }
    }

    public static int numberProvices(int[][] connected){
        int n = connected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(connected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adjList, i, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] connected = {{1,1,0},{1,1,0},{0,0,0}};
        System.out.println(numberProvices(connected));
    }
}

// Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph, and we know DFS takes a time of O(V+2E).
// Space Complexity: O(N) + O(N), Space for recursion stack space and visited array.