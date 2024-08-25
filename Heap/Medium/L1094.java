package Heap.Medium;

// 1094. Car Pooling

import java.util.Arrays;

public class L1094 {

    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[2] - b[2]);
        int[] arr = new int[trips[trips.length-1][2]+1];
        for(int[] trip : trips){
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        for(int i=0;i<=trips[trips.length-1][2];i++){
            capacity -= arr[i];
            if(capacity < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{2,3,7}};
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }
}

//0 1 2 3 4  5   6  7
//    2 2   -2     -2
// return true

// Time Complexity - O(NlogN)
// Space Complexity - O(N)