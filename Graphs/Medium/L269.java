package Graphs.Medium;

// 269. Alien Dictionary

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L269 {

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

    public static String alienOrder(String[] words, int n, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            for(int j=0;j<Math.min(s1.length(), s2.length());j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSortBFS(adjList, k);
        String ans = "";
        for(int it : topo){
            ans += (char)(it + 'a');
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5, k = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(alienOrder(dict, n, k));
    }
}
