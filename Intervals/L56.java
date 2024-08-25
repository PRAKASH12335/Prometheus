package Intervals;

// 56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56 {

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval : intervals){
            if(end >= interval[0]){
                end = Math.max(end, interval[1]);
            }else{
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        Arrays.stream(result).forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}

// Time Complexity - O(nlogn)
// Space Complexity - O(n)
