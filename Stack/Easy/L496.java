package Stack.Easy;

// 496. Next Greater Element I

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class L496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i =n-1;i>=0;i--){
            while(!st.empty() && st.peek() < nums2[i]){
                st.pop();
            }
            if(st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(nums2[i]);
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            hmap.put(nums2[i], res[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = hmap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        Arrays.stream(result).forEach(a -> System.out.println(a));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)