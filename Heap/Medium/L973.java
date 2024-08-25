package Heap.Medium;

// 973. K Closest Points to Origin

import java.util.*;

public class L973 {

    // PQ
    private static Integer distance(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }
    public static int[][] kClosestPQ(int[][] points, int k) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((p1, p2) -> distance(p2).compareTo(distance(p1)));

        for(int[] point : points){
            maxPQ.add(point);
            if(maxPQ.size()>k)
                maxPQ.poll();
        }
        int cnt=0;
        int[][] ans = new int[k][2];
        while(!maxPQ.isEmpty()){
            ans[cnt++] = maxPQ.poll();
        }
        return ans;
    }

    public static int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] res = new int[k][2];
        HashMap<Double, List<Integer>> hmap = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int[] p = points[i];
            Double dist = Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
            List<Integer> point;
            if(hmap.containsKey(dist))
                point = hmap.get(dist);
            else
                point = new ArrayList<>();
            point.add(i);
            hmap.put(dist, point);
            pq.add(dist);
        }

        int cnt = 0;
        while(cnt < k){
            Double dis = pq.poll();
            List<Integer> p = hmap.get(dis);
            for(int i : p){
                res[cnt++] = points[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] res = kClosest(points, k);
        Arrays.stream(res).forEach(a -> System.out.println(a[0] + " " + a[1]));
        int[][] resPQ = kClosestPQ(points, k);
        Arrays.stream(resPQ).forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}

// Time Complexity - O(KlogK)
// Space Complexity - O(K)