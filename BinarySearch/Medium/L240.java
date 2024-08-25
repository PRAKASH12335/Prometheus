package BinarySearch.Medium;

// 240. Serach in 2-D matrix II

public class L240 {

    public static boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n-1;
        while(r<=m && c >=0){
            if(matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target){
                c--;
            }else
                r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums =new int[][]{{1,4,7,11, 15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(nums, target));
    }
}

// Time Complexity - O(m+n)
// Space Complexity - O(1)