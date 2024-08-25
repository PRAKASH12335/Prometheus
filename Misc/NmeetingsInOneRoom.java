package Misc;

// N meetings in one room

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class CustomComparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting m1, Meeting m2){
        if(m1.end < m2.end)
            return -1;
        else if(m1.end > m2.end)
            return 1;
        else if(m1.pos < m2.pos)
            return -1;
        return 1;
    }
}

public class NmeetingsInOneRoom {

    public static List<Integer> maxMeetings(int s[], int e[], int n) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(s[i], e[i], i+1));
        }
        Collections.sort(meetings, new CustomComparator());

        List<Integer> meets = new ArrayList<>();
        meets.add(meetings.get(0).pos);
        int limit = meetings.get(0).end;
        for(int i=0;i<meetings.size();i++){
            if(limit < meetings.get(i).start){
                limit = meetings.get(i).end;
                meets.add(meetings.get(i).pos);
            }
        }
        return meets;
    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,6,7,9,9};
        List<Integer> meet = maxMeetings(start, end, n);
        System.out.println(meet);
    }
}

// Time Complexity - O(N) +O(N*logN) + O(N) = O(N*logN)
// Space Complexity - O(N)