package BinarySearch.Medium;

// 1011. Capacity To Ship Packages Within D Days

public class L1011 {

    public static boolean possible(int[] weights, int max, int days) {
        int sum = 0, cntDays = 1;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i] <= max) {
                sum += weights[i];
            }else{
                sum = weights[i];
                cntDays++;
            }
        }
        return cntDays <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int i=0;i<weights.length;i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        System.out.println(low);
        System.out.println(high);
        while(low <= high){
            int mid = low+(high-low)/2;
            if(possible(weights, mid, days))
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}


// Time Complexity - O(log sum-max+1)*O(n)
// Space Complexity - O(1)