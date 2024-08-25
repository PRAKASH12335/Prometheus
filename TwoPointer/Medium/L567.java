package TwoPointer.Medium;

// 567. Permutation in String

public class L567 {

    public boolean checkPermute(int[] count1, int[] count2){
        for(int i=0;i<26;i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }

    public int[] calculateCount2(String s){
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        return count;
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        int[] count1 = new int[26];
        for(int i=0;i<len1;i++){
            count1[s1.charAt(i)-'a']++;
        }
        int j = len1;
        for(int i=0;i<len2-len1+1;i++){
            int[] count2 = calculateCount2(s2.substring(i, j));
            if(checkPermute(count1, count2)){
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        L567 obj = new L567();
        System.out.println(obj.checkInclusion(s1, s2));
    }
}
