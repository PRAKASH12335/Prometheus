package Striver.Graphs;

// G-51. Number of Islands – II – Online Queries

import java.util.ArrayList;
import java.util.List;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
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

    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if (rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

}

public class G51 {

    public List<Integer> numOfIslands(int n, int m, int[][] operators){
        DisjointSet ds = new DisjointSet(n*m);
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        int[] dirX = {1,0,0,-1};
        int[] dirY = {0,1,-1,0};
        for(int i=0;i<operators.length;i++){
            int x = operators[i][0];
            int y = operators[i][1];
            if(vis[x][y] == true){
                ans.add(cnt);
                continue;
            }
            vis[x][y] = true;
            cnt++;
            for(int ind=0;ind<4;ind++){
                int nx = x + dirX[ind];
                int ny = y + dirY[ind];
                if(nx >=0 && ny >=0 && nx < n && ny < m){
                    if(vis[nx][ny] == true){
                        int nodeNo = m*x + y;
                        int adjNode = m*nx + ny;
                        if(ds.findParent(nodeNo) != ds.findParent(adjNode) ){
                            cnt--;
                            ds.unionBySize(nodeNo, adjNode);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        G51 obj = new G51();
        List<Integer> ans = obj.numOfIslands(n, m, operators);
        System.out.println(ans);
    }
}

// Time Complexity: O(Q*4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
// Space Complexity: O(Q) + O(N*M) + O(N*M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.