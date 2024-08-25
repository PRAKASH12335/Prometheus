package Striver.Graphs;

// G-53. Most Stones Removed with Same Row or Column - DSU

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G53 {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    class DisjointSet{
        DisjointSet(int n){
            for(int i=0;i<=n;i++){
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

    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0;i<n;i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol +1);
        HashMap<Integer, Integer> stonesNode = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stonesNode.put(nodeRow, 1);
            stonesNode.put(nodeCol, 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : stonesNode.entrySet()){
            if(ds.findParent(entry.getKey()) == entry.getKey()){
                cnt++;
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] stones = {
                {0, 0}, {0, 2},
                {1, 3}, {3, 1},
                {3, 2}, {4, 3}
        };
        G53 obj = new G53();
        System.out.println(obj.maxRemove(stones, n));
    }
}

// Time Complexity: O(N), where N = total no. of stones. Here we have just traversed the given stones array several times.
// And inside those loops, every operation is apparently taking constant time. So, the time complexity is only the time of traversal of the array.
// Space Complexity: O(2* (max row index + max column index)) for the parent and size array inside the Disjoint Set data structure.