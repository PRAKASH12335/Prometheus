package BinarySearch.Medium;

// 153. Find Mininmum in rotated sorted Array

public class L154 {

    public static int findMinimum(int[] nums){
        int n = nums.length;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] <= nums[high])
                return nums[low];
            if(nums[mid] < nums[(mid-1+n)%n] && nums[mid] < nums[(mid+1)%n])
                return nums[mid];
            else if (nums[mid] <= nums[high])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMinimum(nums));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)