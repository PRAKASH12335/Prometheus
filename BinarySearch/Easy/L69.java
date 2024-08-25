package BinarySearch.Easy;

// 69. Sqrt(x)

public class L69 {

    public static int mySqrt(int x) {
        int low = 1, high = x/2;
        if(low>high)
            return low;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid == x/mid)
                return mid;
            if(mid > x/mid)
                high = mid-1;
            else
                low = mid+1;
        }
        return high;
    }

    public static void main(String[] args) {
        int x = 28;
        System.out.println(mySqrt(x));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)