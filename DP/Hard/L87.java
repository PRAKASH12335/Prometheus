package DP.Hard;

// 87. Scramble String

public class L87 {

    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 != len2)
            return false;
        if(s1.equals(s2))
            return true;
        int[] count = new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i) -'a']++;
            count[s2.charAt(i) -'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i] != 0)
                return false;
        }

        for(int i=1;i<len1;i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(len1-i)) && isScramble(s1.substring(i), s2.substring(0, len1-i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
        L87 obj = new L87();
        System.out.println(obj.isScramble(s1, s2));
    }
}
