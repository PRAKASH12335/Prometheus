package Misc;

// Count inversions in an array

import java.util.ArrayList;

public class CountInversionsinanArray {

    public static int merge(int[] nums, int start, int mid, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = start;
        int right = mid+1;
        int cnt = 0;

        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                cnt += (mid-left+1);
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= end){
            temp.add(nums[right]);
            right++;
        }

        for(int i=start;i<=end;i++){
            nums[i] = temp.get(i-start);
        }
        return cnt;
    }

    public static int mergeSort(int[] nums, int start, int end) {
        int cnt = 0;
        if(start < end){
            int mid = (start+end)/2;
            cnt += mergeSort(nums, start, mid);
            cnt += mergeSort(nums, mid+1, end);
            cnt += merge(nums, start, mid, end);
        }
        return cnt;
    }

    public static int numberOfInversions(int[] nums, int n) {
        return mergeSort(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(numberOfInversions(nums, nums.length));
    }
}

// Time Complexity - O(NlogN)
// Space Complexity - O(N)