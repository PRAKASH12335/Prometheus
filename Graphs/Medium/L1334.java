package Graphs.Medium;

// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

import java.util.Arrays;

public class L1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        for(int i=0;i<n;i++){
            dist[i][i] = 0;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            dist[u][v] = edge[2];
            dist[v][u] = edge[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for(int city=0;city<n;city++){
            int cnt = 0;
            for(int adjCity = 0;adjCity<n;adjCity++){
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }

    public static void main(String[] args) {
        int n = 4, distanceThreshold = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        L1334 obj = new L1334();
        System.out.println(obj.findTheCity(n, edges, distanceThreshold));
    }
}

// Time Complexity: O(V3), as we have three nested loops each running for V times, where V = no. of vertices.
// Space Complexity: O(V2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph.
