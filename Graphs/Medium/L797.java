package Graphs.Medium;

// 797. All Paths From Source to Target

import java.util.*;

public class L797 {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int num : graph[i]){
                adjList.get(i).add(num);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));
        while(!q.isEmpty()){
            List<Integer> path = q.poll();
            int lastVertex = path.get(path.size()-1);
            if(lastVertex == n-1){
                ans.add(path);
            }else{
                for(int it : adjList.get(lastVertex)){
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(it);
                    q.add(newPath);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
}

// Time Complexity - O(M*N * log M*N)
// Space Complexity - O(M*N)