package Striver.Graphs;


import java.util.ArrayList;
import java.util.List;

public class G46 {

    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    G46(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findParent(int u){
        if(parent.get(u) == u)
            return u;
        int ulp = findParent(parent.get(u));
        parent.set(u, ulp);
        return parent.get(u);
    }

    public void unionByRank(int u, int v){
        int ulp_u = parent.get(u);
        int ulp_v = parent.get(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = parent.get(u);
        int ulp_v = parent.get(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }

    public static void main(String[] args) {
//        G46 ds = new G46(7);
//        ds.unionByRank(1, 2);
//        ds.unionByRank(2, 3);
//        ds.unionByRank(4, 5);
//        ds.unionByRank(6, 7);
//        ds.unionByRank(5, 6);
//
//        // if 3 and 7 same or not
//        if (ds.findParent(3) == ds.findParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");
//
//        ds.unionByRank(3, 7);
//        if (ds.findParent(3) == ds.findParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");


        G46 ds = new G46(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
