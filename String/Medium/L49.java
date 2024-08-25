package String.Medium;

// 49. Group Anagrams

import java.util.*;

public class L49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> hmap = new HashMap<>();
        for(String str : strs){
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = new String(sorted);
            if(!hmap.containsKey(sortedStr)) {
                hmap.put(sortedStr, new ArrayList<>());
            }
            List<String> strList = hmap.get(sortedStr);
            strList.add(str);
            hmap.put(sortedStr, strList);

//            hmap.putIfAbsent(sortedStr, new ArrayList<>());
//            hmap.get(sortedStr).add(str);
        }
//        ans.addAll(hmap.values());
        return new ArrayList<>(hmap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
