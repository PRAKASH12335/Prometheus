package Heap.Medium;

// 1642. Furthest Building You Can Reach

import java.util.PriorityQueue;

public class L1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i+1] - heights[i];
            if (diff <= 0)
                continue;
            pq.add(diff);
            if(pq.size() > ladders){
                bricks -= pq.poll();
            }
            if(bricks < 0)
                return i;
        }
        return heights.length-1;
    }

    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5, ladder = 1;
        L1642 obj = new L1642();
        System.out.println(obj.furthestBuilding(heights, bricks, ladder));
    }
}


// Time Complexity - 0(nlog(ladder))
// Space Complexity - O(log(ladder))