package Graphs.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L210 {

    public static int[] findOrder(int numCourses, int[][] perequisites){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<perequisites.length;i++){
            indegree[perequisites[i][0]]++;
            adjList.get(perequisites[i][1]).add(perequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] topo = new int[numCourses];
        int i = 0, count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            topo[i++] = temp;
            count++;
            for(int it : adjList.get(temp)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return numCourses == count ? topo : new int[]{};
    }
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] pererequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] topo = findOrder(numCourses, pererequisites);
        for(int i=0;i< topo.length;i++){
            System.out.println(topo[i] + " ");
        }
    }
}

// Time complexity - O(N)
// Space complexity - O(N)