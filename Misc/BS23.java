package Misc;

// BS 23. Row with maximum number of 1s

public class BS23 {
    public static int lowerBound(int[] arr, int target){
        int low = 0, high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid+1;
        }
        return ans;
    }
    public static int rowWithMax1s(int[][] nums){
        int m = nums.length, n = nums[0].length;
        int cnt_max = 0, maxRow = -1;
        for(int i=0;i<m;i++){
            int cnt_ones = n-lowerBound(nums[i], 1);
            if(cnt_max < cnt_ones){
                cnt_max = cnt_ones;
                maxRow = i;
            }
        }
        return maxRow;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,0,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,1,1},
                {0,0,1,1,1}};
        System.out.println(rowWithMax1s(nums));
    }
}


// Time Complexity - O(m X logn) where m = row number and n = col number
// Space Complexity - O(1)