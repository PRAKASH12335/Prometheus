package Heap.Medium;

// 692. Top K Frequent Words

import java.util.*;

public class L692 {

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for(String word : words){
            hmap.put(word, hmap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> minPQ = new PriorityQueue<>((w1, w2) -> hmap.get(w1) == hmap.get(w2) ? w2.compareTo(w1) : hmap.get(w1) - hmap.get(w2));

        for(String word : hmap.keySet()){
            minPQ.add(word);
            if(minPQ.size() > k)
                minPQ.poll();
        }
        List<String> ans = new ArrayList<>();
        while(!minPQ.isEmpty()){
            ans.add(minPQ.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding","leetcode"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
}

// Time Complexity - O(NlogK)
// Space Complexity - O(N)