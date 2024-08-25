package String.Easy;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true


public class L242 {

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if(s.length() != t.length())
            return false;

        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)