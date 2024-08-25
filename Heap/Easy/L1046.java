package Heap.Easy;

// 1046. Last Stone Weight

import java.util.Collections;
import java.util.PriorityQueue;

public class L1046 {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones){
            pq.add(n);
        }
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            int res = x-y;
            pq.add(res);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)
