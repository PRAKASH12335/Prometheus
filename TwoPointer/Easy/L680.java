package TwoPointer.Easy;

// 680. Valid Palindrome II

public class L680 {

    public static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int i = 0, j= s.length()-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abbc";
        System.out.println(validPalindrome(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)