package TwoPointer.Easy;

import java.util.Arrays;

// Sort Array by Parity
public class L905 {

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[] sortArrayByParity(int[] nums){
        int i=0,j = nums.length-1;
        while(i<j){
            if(nums[i]%2 > nums[j]%2)
                swap(nums, i, j);
            else if(nums[i]%2 == 0)
                i++;
            else if(nums[j]%2 == 1)
                j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,1};
        int[] ans = sortArrayByParity(nums);
        Arrays.stream(ans).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)