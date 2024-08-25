package BinarySearch.Medium;

// Search in 2-D Matrix

public class L74 {

    public static boolean searchMatix(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid/n, col = mid%n;
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums =new int[][]{{1,3,5,7},
                {10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatix(nums, target));
    }
}

// Time Complexity - O(log(m*n))
// Space Complexity - O(1)