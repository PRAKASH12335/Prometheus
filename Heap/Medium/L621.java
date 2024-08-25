package Heap.Medium;

// 621. Task Scheduler

import java.util.Arrays;

public class L621 {

    public static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char c : tasks){
            arr[c - 'A']++;
        }
        //
        int maxFreq = Arrays.stream(arr).max().getAsInt();
        int maxFreqTaskRange = (maxFreq-1)*(n+1);
        System.out.println(maxFreqTaskRange);
        int nMaxFreq = (int)Arrays.stream(arr).filter(a -> a == maxFreq).count();
        return Math.max(maxFreqTaskRange + nMaxFreq, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
// A B . A B . A

// Time Complexity - O(N)
// Space Complexity - O(26)
