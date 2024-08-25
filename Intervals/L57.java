package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class L57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0 || newInterval.length == 0)
            return intervals;
        if(intervals.length == 0)
            return new int[][]{newInterval};
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<Interval> intervalList = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        Interval newIntervalList = new Interval(newInterval[0], newInterval[1]);
        for(int[] interval : intervals){
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        boolean flag = false;
        for(int i=0;i<intervalList.size();i++){
            Interval intervalIterator = intervalList.get(i);
            if(intervalIterator.end < newIntervalList.start){
                result.add(intervalIterator);
            }else if(intervalIterator.start > newIntervalList.end){
                result.add(newIntervalList);
                result.addAll(intervalList.subList(i, intervalList.size()));
                flag = true;
                break;
            }else{
                int start = Math.min(intervalIterator.start, newIntervalList.start);
                int end = Math.max(intervalIterator.end, newIntervalList.end);
                newIntervalList.start = start;
                newIntervalList.end = end;
            }
        }
        if(!flag){
            result.add(newIntervalList);
        }
        int[][] res = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0] = result.get(i).start;
            res[i][1] = result.get(i).end;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = insert(intervals, newInterval);
        Arrays.stream(result).forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}
