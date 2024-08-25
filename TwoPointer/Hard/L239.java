package TwoPointer.Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L239 {

    public static int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        if(n<k)
            return new int[]{};
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int index = 0;
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.addLast(i);
        }
        ans[index++] = nums[dq.peekFirst()];
        for(int i=k;i<n;i++){
            while(!dq.isEmpty() && i-dq.peekFirst() >= k)
                dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.addLast(i);
            ans[index++]=nums[dq.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        Arrays.stream(ans).forEach(a -> System.out.println(a));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)