package Graphs.Medium;

// 207. Course Schedule

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List topo = new LinkedList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(topo.size() == numCourses) return true;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] pererequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(numCourses, pererequisites));
    }
}

// Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.
// Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).
// Extra O(N) for storing the topological sorting. Total ~ O(3N).