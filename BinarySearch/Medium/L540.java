package BinarySearch.Medium;

// 540. Single Element in a Sorted Array

public class L540 {

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int low = 1, high = n-2;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            // We are in left
            if(mid%2 == 1 && nums[mid] == nums[mid-1] || mid%2 == 0 && nums[mid] == nums[mid+1]){
                low = mid+1;
            }
            // We are in right
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(singleNonDuplicate(nums));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)