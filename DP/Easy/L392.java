package DP.Easy;

// 392. Is Subsequence

public class L392 {

    //
    public static boolean isSubsequence(String s, String t){
        if(s.length()==0)
            return true;
        int j=0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(j) == t.charAt(i)){
                j++;
                if(j== s.length())
                    return true;
            }
        }
        return false;
    }

    // Recursion
    public static boolean isSubsequence(int i, int j, String s, String t) {
        if(i == s.length())
            return true;
        if(i<s.length() && j == t.length())
            return false;
        if(i == s.length() && j == t.length())
            return true;

        if(s.charAt(i) == t.charAt(j)){
            return isSubsequence(i+1, j+1, s, t);
        }else
            return isSubsequence(i,j+1, s, t);
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        int i = 0, j = 0;
        System.out.println(isSubsequence(i, j, s, t));
        System.out.println(isSubsequence(s, t));
    }
}


// Time complexity - O(max(M,N))
// Space complexity - O(1)