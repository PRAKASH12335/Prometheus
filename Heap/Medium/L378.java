package Heap.Medium;

// 378. Kth Smallest Element in a Sorted Matrix

import java.util.Collections;
import java.util.PriorityQueue;

public class L378 {

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        if(k == 1)
            return matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxPQ.add(matrix[i][j]);
                if(maxPQ.size() > k)
                    maxPQ.poll();
            }
        }
        return maxPQ.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}

// Time Complexity - O(M*NlogK)
// Space Complexity - O(K)