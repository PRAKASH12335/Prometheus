package BinarySearch.Medium;

// 875. Koko Eating Bananas

public class L875 {

    public static int calculate(int[] piles, int mid){
        int count = 0;
        for(int i=0;i<piles.length;i++){
            count += Math.ceil((double)piles[i]/(double)(mid));
        }
        return count;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            high = Math.max(high, piles[i]);
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            int totalHours = calculate(piles, mid);
            if(totalHours <= h){
                high = mid-1;
            }else
                low = mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
