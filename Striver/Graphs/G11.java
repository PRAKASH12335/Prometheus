package Striver.Graphs;

// G-11. Detect a Cycle in an Undirected Graph using BFS

import java.util.*;

class Node{
    int node;
    int parent;
    Node(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

public class G11 {

    public static boolean bfs(int node, List<List<Integer>> adjList, boolean[] vis){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));
        vis[node] = true;

        while(!q.isEmpty()){
            Node temp = q.poll();
            int par = temp.parent;
            int curr = temp.node;
            for(int it : adjList.get(curr)){
                if(vis[it] != false){
                    vis[it] = true;
                    q.add(new Node(it, curr));
                }else if(par != it){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleBFS(List<List<Integer>> adjList, int V){
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(bfs(i, adjList, vis))
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
        System.out.println(detectCycleBFS(adjList, n));
    }
}

// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
// In the case of connected components of a graph, it will take another O(N) time.
// Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visited array.