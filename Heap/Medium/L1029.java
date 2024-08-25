package Heap.Medium;

// 1029. Two City Scheduling

import java.util.PriorityQueue;

public class L1029 {

    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum=0;

        for(int[] arr : costs){
            sum+=arr[0];
            pq.add(arr[0]-arr[1]);
            if(pq.size()>costs.length/2)
                pq.poll();
        }

        while(pq.size()>0)
            sum-=pq.poll();

        return sum;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        //                -10,    -170,     350,    10
        L1029 obj = new L1029();
        System.out.println(obj.twoCitySchedCost(costs));
    }
}
