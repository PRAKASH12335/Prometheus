package String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        if(n<m)
            return new ArrayList<>();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<m;i++){
            arr1[s.charAt(i)-'a']++;
            arr2[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(arr1, arr2))
            ans.add(0);

        for(int i=m;i<n;i++){
            arr1[s.charAt(i)-'a']++;
            arr1[s.charAt(i-m)-'a']--;
            if(Arrays.equals(arr1, arr2))
                ans.add(i-m+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)