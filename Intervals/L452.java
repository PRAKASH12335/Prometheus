package Intervals;

import java.util.Arrays;

// 452. Minimum Number of Arrows to Burst Balloons
public class L452 {

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        int ans = 1;
        int limit = points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0] > limit){
                ans++;
                limit = Math.max(limit, points[i][1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(findMinArrowShots(points));
    }
}

// Time Complexity - O(nlogn)
// Space Complexity - O(1)