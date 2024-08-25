package TwoPointer.Medium;

import java.util.Arrays;

// 75. Sort Colors

public class L75 {

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] sortColors(int[] nums){
        int low=0, mid=0, high= nums.length-1;
        while(mid <= high){
            switch(nums[mid]){
                case 0 :    swap(nums, low, mid);
                            low++;
                            mid++;
                            break;
                case 1 :    mid++;
                            break;
                case 2 :    swap(nums, mid, high);
                            high--;
                            break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)