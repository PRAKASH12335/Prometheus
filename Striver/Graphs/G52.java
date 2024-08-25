package Striver.Graphs;

// 827. Making A Large Island
// G-52. Making a Large Island - DSU

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class G52 {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    class DisjointSet{
        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        public int findParent(int u){
            if(parent.get(u) == u)
                return u;
            int ulp_u = findParent(parent.get(u));
            parent.set(u, ulp_u);
            return parent.get(u);
        }

        public void unionBySize(int u, int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    boolean valid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[] dirX = {1,0,0,-1};
        int[] dirY = {0,1,-1, 0};
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 0) continue;
                for(int i=0;i<4;i++){
                    int nrow = row + dirX[i];
                    int ncol = col + dirY[i];
                    if(valid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                        int node = row*n + col;
                        int adjNode = nrow*n + ncol;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }

        int mx = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 1) continue;
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dirX[ind];
                    int newc = col + dirY[ind];
                    if (valid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.findParent(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for(int parents : components){
                    sizeTotal += size.get(parents);
                }
                mx = Math.max(mx, sizeTotal+1);
            }
        }
        for(int cellNo=0;cellNo<n*n;cellNo++){
            mx = Math.max(mx, size.get(ds.findParent(cellNo)));
        }
        return mx;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{0,1,1}};
        G52 obj = new G52();
        System.out.println(obj.largestIsland(grid));
    }
}

// Time Complexity: O(N2)+O(N2) ~ O(N2) where N = total number of rows of the grid.
// Inside those nested loops, all the operations are taking apparently constant time. So, O(N2) for the nested loop only, is the time complexity.
// Space Complexity: O(2*N2) where N = the total number of rows of the grid.
// This is for the two arrays i.e. parent array and size array of size N2 inside the Disjoint set.