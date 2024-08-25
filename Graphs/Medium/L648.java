package Graphs.Medium;

// 684. Redundant Connection

import java.util.ArrayList;
import java.util.List;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
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
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class L648 {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        int[] ans = new int[2];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(ds.findParent(u-1) == ds.findParent(v-1)){
                ans[0] = u;
                ans[1] = v;
            }else{
                ds.unionBySize(u-1, v-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        L648 obj = new L648();
        int[] res = obj.findRedundantConnection(edges);
        System.out.println("["+res[0] + "," + res[1] + "]");
    }
}

// Time Complexity: O(N*4α) ~ O(N) where N = no. of edges. The term 4α is so small that it can be considered constant.
// Space Complexity: O(N), where N = no. of edges