package TwoPointer.Medium;

// 189. Rotate Array

import java.util.Arrays;

public class L189 {
    private void reverse(int i, int j, int[] nums){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % nums.length; // k = 3
        // 1 2 3 4 5 6 7
        reverse(0, size-k-1, nums);
        // 4 3 2 1 5 6 7
        reverse(size-k, size-1, nums);
        // 4 3 2 1 7 6 5
        reverse(0, size-1, nums);
        // 5 6 7 1 2 3 4
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        L189 obj = new L189();
        obj.rotate(nums, k);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)