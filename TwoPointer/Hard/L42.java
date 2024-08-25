package TwoPointer.Hard;


// 42. Trapping Rain Water

public class L42 {

    //DP
    public static int trapDP(int[] height){
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        int[] right = new int[n];
        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        int water = 0;
        for(int i=0;i<n;i++){
            water += Math.min(left[i], right[i])- height[i];
        }
        return water;
    }

    // Time complexity - O(N)
    // Space complexity - O(N)

    public static int trap(int[] height){
        int water = 0, n = height.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n-1;
        while(left < right){
            if(height[left] < height[right]){
                if(leftMax < height[left])
                    leftMax = height[left];
                else
                    water += leftMax - height[left];
                left++;
            }else{
                if(rightMax < height[right])
                    rightMax = height[right];
                else
                    water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    // Time complexity - O(N)
    // Space complexity - O(1)

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trapDP(height));
    }
}

// Dry run :
// left = 0 1 1 2 2 2 2 3 3 3 3 3
// right =3 3 3 3 3 3 3 3 2 2 2 1
// water =0 0 1 0 1 2 1 0 0 1 0 0

