package Striver.Graphs;

import java.util.Arrays;

// G-42. Floyd Warshall Algorithm
public class G42 {

    public void shortest_distance(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++) {
                if(i == j)
                    matrix[i][j] = 0;
                else if (matrix[i][j] == -1)
                    matrix[i][j] = (int)(1e9);
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for (int j=0;j<n;j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] matrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = -1;
            }
        }
        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][2] = 3;
        matrix[3][0] = 3;
        matrix[3][1] = 5;
        matrix[3][2] = 4;
        G42 obj = new G42();
        obj.shortest_distance(matrix);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Time Complexity: O(V3), as we have three nested loops each running for V times, where V = no. of vertices.
// Space Complexity: O(V2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph.