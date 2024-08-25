package TwoPointer.Easy;

// 2108. Find First Palindromic String in the Array

public class L2108 {

    public boolean isPalin(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(isPalin(words[i]))
                return words[i];
        }
        return "";
    }
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        L2108 obj = new L2108();
        System.out.println(obj.firstPalindrome(words));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)