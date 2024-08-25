package Stack.Medium;

// 84. Largest Rectangle in Histogram

import java.util.Stack;

public class L84 {
    public static int largestRectangleArea(int[] heights){
        int i = 0, n = heights.length, area = 0, maxArea = 0;
        Stack<Integer> st = new Stack<>();
        while(i<n){
            if(st.isEmpty() || heights[st.peek()] <= heights[i]){
                st.push(i++);
            }else{
                int top = st.pop();
                if(st.isEmpty())
                    area = heights[top]*i;
                else
                    area = heights[top]*(i-st.peek()-1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty())
                area = heights[top]*i;
            else
                area = heights[top]*(i-st.peek()-1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = new int[]{2,3,1};
        System.out.println(largestRectangleArea(heights));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)
