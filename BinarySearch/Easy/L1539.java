package BinarySearch.Easy;

// 1539. Kth Missing Positive Number

public class L1539 {

    public static int findKthPositiveLS(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]<= k){
                k++;
            }else
                break;
        }
        return k;
    }
// Time Complexity: O(N), N = size of the given array.
// Reason: We are using a loop that traverses the entire given array in the worst case.
// Space Complexity: O(1) as we are not using any extra space to solve this problem.

    public static int findKthPositiveBS(int[] arr, int k) {
        int n = arr.length;
        int low =0, high = n-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid]-(mid+1)<k)
                low = mid+1;
            else
                high = mid-1;
        }
        return low+k; // or return k + high + 1;
    }
// Time Complexity: O(logN), N = size of the given array.
// Reason: We are using the simple binary search algorithm.
// Space Complexity: O(1) as we are not using any extra space to solve this problem.

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k =5;
        System.out.println(findKthPositiveBS(arr, k));
        System.out.println(findKthPositiveLS(arr, k));
    }
}
