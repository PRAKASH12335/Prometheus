package Heap.Easy;

import java.util.PriorityQueue;

// 703. Kth Largest Element in a Stream
public class L703 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int currK;

    L703(int k, int[] nums){
        currK = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val){
        if(pq.size() < currK){
            pq.add(val);
        }else{
            if(val > pq.peek()){
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        L703 l = new L703(3, new int[]{4, 5, 8, 2});
        System.out.println(l.add(3));   // return 4
        System.out.println(l.add(5));   // return 5
        System.out.println(l.add(10));  // return 5
        System.out.println(l.add(9));   // return 8
        System.out.println(l.add(4));   // return 8
    }
}

// Time complexity: O(nlogk)
// Space complexity: O(k)