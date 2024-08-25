package TwoPointer.Medium;

// 3. Longest Substring Without Repeating Characters

import java.util.HashMap;
import java.util.HashSet;

public class L3 {

    public static int lengthOfLongestSubstringHashMap(String s) {
        int i=0, j=0, n=s.length();
        int maxLength = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        while(j < n){
            char c = s.charAt(j);
            if(hmap.containsKey(c)){
                if(hmap.get(c) >= i) {
                    i = hmap.get(c) + 1;
                }
            }
            hmap.put(c, j);
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int i=0, j=0, n=s.length();
        int maxLength = 0;
        HashSet<Character> hset = new HashSet<>();
        while(i<n && j<n){
            if(!hset.contains(s.charAt(j))){
                hset.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j-i);
            }else if (hset.contains(s.charAt(i))){
                hset.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringHashMap(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)