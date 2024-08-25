package Stack.Medium;

// 85. Maximal Rectangle

import java.util.Stack;


public class L85 {
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
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                                     {'1','0','1','1','1'},
                                     {'1','1','1','1','1'},
                                     {'1','0','0','1','0'}};
        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '0'){
                    heights[i][j] = 0;
                }else{
                    heights[i][j] = i == 0 ? 1 : 1+heights[i-1][j];
                }
            }
        }
        int area = 0;
        for(int i=0;i<m;i++){
            area = Math.max(area, largestRectangleArea(heights[i]));
        }
        System.out.println(area);
    }
}

// Time complexity - O(N2)
// Space complexity - O(N2)
