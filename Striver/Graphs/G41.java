package Striver.Graphs;

// G-41. Bellman Ford Algorithm

import java.util.ArrayList;
import java.util.Arrays;

public class G41 {

    public int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
//        int[][] edges = {{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};
        ArrayList<ArrayList<Integer>> edges = new ArrayList() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        int V = 6;
        G41 obj = new G41();
        int[] result = obj.bellman_ford(V, edges, 0);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }
}

// Note : works for both Directed & Undirected grahs. You need to convert Undirected graph into directed one.

// Time Complexity: O(V*E), where V = no. of vertices and E = no. of Edges.
// Space Complexity: O(V) for the distance array which stores the minimized distances.