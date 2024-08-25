package BinarySearch.Medium;

// 1482. Minimum Number of Days to Make m Bouquets

import java.util.Arrays;

public class L1482 {

    public static boolean possibleDays(int[] bloomDay, int m, int k, int mid){
        int totalBouquet = 0;
        int window = 0;
        for(int i=0;i< bloomDay.length;i++){
            if(bloomDay[i] <= mid){
                window++;
            }else{
                totalBouquet += window/k;
                window = 0;
            }
        }
        totalBouquet+=(window/k);
        return totalBouquet >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long)m*k;
        if(n < val) return -1;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while(low <= high){
            int mid = low+(high-low)/2;
            if(possibleDays(bloomDay, m, k, mid)){
                high = mid - 1;
            }else
                low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}


// Time Complexity - O(N * log max-min+1)
// Space Complexity - O(1)