package TwoPointer.Medium;

// 31. Next Permutation

import java.util.Arrays;

public class L31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;
        for(i=n-1;i>0;i--){
            if (nums[i-1] < nums[i])
                break;
        }
        if(i == 0){
            // 3 2 1
            Arrays.sort(nums);
            return;
        }
        // 1    2    5    4    3
        //    small  i        n-1
        //          temp
        //          big
        int small = i-1;
        int big = i;
        int temp = i;
        for(i=n-1;i>=big;i--){
            if(nums[i] > nums[small] && nums[i] < nums[temp]){
                temp = i;
            }
        }
        int temp1 = nums[small];
        nums[small] = nums[temp];
        nums[temp] = temp1;
        // 1    3    5    4    2
        //    small
        Arrays.sort(nums, small+1, n);
        // 1    3    2    4    5
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,4,3};
        L31 obj = new L31();
        obj.nextPermutation(nums);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)
