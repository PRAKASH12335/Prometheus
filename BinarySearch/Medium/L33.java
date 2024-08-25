package BinarySearch.Medium;

// 33. Search in Rotated Sorted Array

public class L33 {

    public static int search(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] <= nums[high]){
                if(nums[mid] <= target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }else{
                if(nums[low] <= target && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(search(nums, target));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)