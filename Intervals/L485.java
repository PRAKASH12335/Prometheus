package Intervals;

// 435. Non-overlapping Intervals

import java.util.Arrays;

public class L485 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int count = 0;
        int end = intervals[0][1];
        for(int i=1;i<n;i++){
            if(end > intervals[i][0]){
                count++;
                end = Math.min(end, intervals[i][1]);
            }else
                end = intervals[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}

// Time Complexity - O(nlogn)
// Space Complexity - O(n)