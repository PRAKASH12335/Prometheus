package DP.Hard;

// 403. Frog Jump

import java.util.HashSet;
import java.util.Set;

public class L403 {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        Set<Integer>[] set = new HashSet[n];
        for(int i=0;i<n;i++){
            set[i] = new HashSet<>();
        }
        set[0].add(0);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int t = stones[i]-stones[j];
                if(set[j].contains(t) || set[j].contains(t+1) || set[j].contains(t-1)){
                    set[i].add(t);
                }
            }
        }
        if(set[n-1].size() > 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        L403 obj = new L403();
        System.out.println(obj.canCross(stones));
    }
}

// Time Complexity - O(n^2)
// Space Complexity - O(n)