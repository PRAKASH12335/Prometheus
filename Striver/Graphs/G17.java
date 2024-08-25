package Striver.Graphs;

// G-18. Bipartite Graph

import java.util.*;

public class G17 {

    // DFS
    public static boolean bipartiteDFS(int node, int col, List<List<Integer>> adjList, int[] color){
        color[node] = col;
        for(int it : adjList.get(node)){
            if(color[it] == -1){
                if(bipartiteDFS(it, 1 - col, adjList, color) == false)
                    return false;
            }
            else if(color[it] == col){
                return false;
            }
        }
        return true;
    }
    public static boolean isBipartiteDFS(List<List<Integer>> adjList) {
        int n = adjList.size();
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(bipartiteDFS(i, 0, adjList, color) == false)
                    return false;
            }
        }
        return true;
    }
// Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.
// Space Complexity: O(3V) ~ O(V), Space for DFS stack space, colour array and an adjacency list.


    // BFS
    public static boolean bipartiteBFS(int node, List<List<Integer>> adjList, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 1;

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int it : adjList.get(temp)){
                if(color[it] == -1){
                    color[it] = 1 - color[temp];
                    q.offer(it);
                }
                else if(color[it] == color[temp]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartiteBFS(List<List<Integer>> adjList) {
        int n = adjList.size();
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(bipartiteBFS(i, adjList, color) == false)
                    return false;
            }
        }
        return true;
    }
// Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.
// Space Complexity: O(3V) ~ O(V), Space for queue data structure, colour array and an adjacency list.

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 4;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(3);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(0);
        adjList.get(3).add(2);

        System.out.println(isBipartiteBFS(adjList));
        System.out.println(isBipartiteDFS(adjList));
    }
}

