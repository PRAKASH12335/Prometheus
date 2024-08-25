package Graphs.Medium;

// 841. Keys and Rooms

import java.util.*;

public class L841 {
    public static boolean keysAndRooms(List<List<Integer>> arr){
        int n = arr.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<arr.get(0).size();i++){
            q.add(arr.get(0).get(i));
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            if(visited[curr] == false){
                visited[curr] = true;
                for(int i=0;i<arr.get(curr).size();i++){
                    q.add(arr.get(curr).get(i));
                }
            }
        }

        for(int i=0;i<n;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        list.add(Arrays.asList());
        System.out.println(keysAndRooms(list));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)