package Intervals;

// 759. Employee Free Time

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L759 {

    class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> employeeFreeTime(int[][] schedule) {
        List<Interval> ans = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        for(int[] emp : schedule){
            intervals.add(new Interval(emp[0], emp[1]));
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            if(end < interval.start){
                ans.add(new Interval(end, interval.start));
            }
            end = Math.max(end, interval.end);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] schedule ={{1,3},{6,7},{2,4},{2,5},{9,12}};
        L759 obj = new L759();
        List<Interval> intervals = obj.employeeFreeTime(schedule);
        for(Interval i : intervals){
            System.out.print("["+i.start+ ", " + i.end+"]");
        }
    }
}

// Time Complexity - O(N*logN)
// Spacee Complexity - O(N)