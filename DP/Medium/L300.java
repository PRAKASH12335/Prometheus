package DP.Medium;



import java.util.ArrayList;
import java.util.Arrays;

public class L300 {

    // Binary Search
    public static int lengthOfLISBinarySearch(int[] nums) {
        if(nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int length = 1;
        for(int i=1;i< nums.length;i++){
            if (nums[i] > dp[length -1]){
                dp[length] = nums[i];
                length++;
            }else{
                int index = Arrays.binarySearch(dp, 0, length, nums[i]);
                if(index < 0)
                    index = -(index+1);
                dp[index] = nums[i];
            }
        }
        return length;
    }

    // DP
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }


    // DP printing LIS
    public static int printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash,1);

        for(int i = 0;i<n;i++){
            hash[i] = i;
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;
        for(int i=0;i<n;i++){
            if(ans < dp[i]){
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        // reverse the array
        System.out.print("The subsequence elements are ");
        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISBinarySearch(nums));
        System.out.println(printLIS(nums));
    }
}

// DP
// Time complexity: O(N * N)
// Space complexity: O(N)

// Binary Search
// Time complexity: O(N Log N)
// Space complexity: O(N)