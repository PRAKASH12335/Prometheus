package Heap.Medium;

// 767. Reorganize String

import java.util.HashMap;
import java.util.PriorityQueue;

public class L767 {

    public static String reorganizeString(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> maxPQ = new PriorityQueue((a, b) -> countMap.get(b) - countMap.get(a));
        for(char c : countMap.keySet()){
            maxPQ.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(maxPQ.size() > 1){
            char first = maxPQ.poll();
            char second = maxPQ.poll();
            int countFirst = countMap.get(first);
            int countSecond = countMap.get(second);
            sb.append(first).append(second);
            countMap.put(first, countFirst-1);
            countMap.put(second, countSecond-1);
            if(countMap.get(first) > 0)
                maxPQ.add(first);
            if(countMap.get(second) > 0)
                maxPQ.add(second);
        }

        if(maxPQ.size() == 1) {
            char temp = maxPQ.poll();
            if (countMap.get(temp) > 1)
                return "";
            else
                sb.append(temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}

// Time Complexity - O(NlogN)
// Space Complexity - O(N)