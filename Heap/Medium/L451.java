package Heap.Medium;

// 451. Sort Characters By Frequency

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L451 {

    public static String frequencySort(String s) {
        if(s.length() == 0)
            return "";
        Map<Character, Integer> hmap = new HashMap<>();
        for(Character c : s.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> maxPQ = new PriorityQueue<>((a,b) -> hmap.get(b) - hmap.get(a));
        for(char c : hmap.keySet()){
            maxPQ.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!maxPQ.isEmpty()){
            char c = maxPQ.poll();
            int count = hmap.get(c);
            while(count-->0){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}

// Time Complexity - O(NlogK)
// Space Complexity - O(N)