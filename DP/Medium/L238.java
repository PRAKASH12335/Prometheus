package DP.Medium;

import java.util.Arrays;

public class L238 {
    public static int[] productExceptSelf(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        left[0] = 1;
        for(int i=1;i<n;i++){
            left[i] = left[i-1]*arr[i-1];
        }
        Arrays.stream(left).forEach(a -> System.out.print(a + " "));
        System.out.println();

        int[] right = new int[n];
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1]*arr[i+1];
        }
        Arrays.stream(right).forEach(a -> System.out.print(a + " "));
        System.out.println();

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] result = productExceptSelf(arr);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }
}
