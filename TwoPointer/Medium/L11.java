package TwoPointer.Medium;

public class L11 {
    public static int maxArea(int[] height){
        int area = 0, l = 0, h = height.length-1;
        while(l<h){
            area = Math.max(area, (h-l)*(Math.min(height[l], height[h])));
            if(height[l] < height[h])
                l++;
            else
                h--;
        }
        return area;
    }
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

// Time complexity - O(N), N = height.length
// Space complexity - O(1)
