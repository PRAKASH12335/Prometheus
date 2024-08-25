package Heap.Medium;

// 347. Top K Frequent Elements

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class L347 {

    public static int[] topKFrequentPQ(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums){
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> hmap.get(a)-hmap.get(b));
        for(int key : hmap.keySet()){
            minPQ.add(key);
            if(minPQ.size() > k)
                minPQ.poll();
        }

        int index = 0;
        while(!minPQ.isEmpty()){
            ans[index++] = minPQ.poll();
        }
        return ans;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums)
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> hmap.get(b)-hmap.get(a));
        for(int num : hmap.keySet()){
            maxPQ.add(num);
        }
        int index = 0;
        while(k-->0){
            ans[index++] = maxPQ.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        Arrays.stream(ans).forEach(a -> System.out.println(a));

        int[] ans2 = topKFrequentPQ(nums, k);
        Arrays.stream(ans2).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(NlogK)
// Space Complexity - O(N)