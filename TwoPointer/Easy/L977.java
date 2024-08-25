package TwoPointer.Easy;

import java.util.Arrays;

// Square of the sorted Array
public class L977 {
    public static int[] squareSortedArray(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int index = n-1, i = 0, j = n-1;
        while(i<=j){
            int pow1 = nums[i]*nums[i];
            int pow2 = nums[j]*nums[j];
            if(pow1 > pow2){
                ans[index--] = pow1;
                i++;
            }else{
                ans[index--] = pow2;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] ans = squareSortedArray(nums);
        Arrays.stream(ans).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)