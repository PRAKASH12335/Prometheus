package TwoPointer.Medium;

// 438. Find All Anagrams in a String

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L438 {

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if(n < m)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<m;i++){
            arr1[s.charAt(i) - 'a']++;
            arr2[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(arr1, arr2))
            ans.add(0);

        for(int i=m;i<n;i++){
            arr1[s.charAt(i) - 'a']++;
            arr1[s.charAt(i-m) - 'a']--;
            if(Arrays.equals(arr1, arr2))
                ans.add(i-m+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        L438 obj = new L438();
        System.out.println(obj.findAnagrams(s, p));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)