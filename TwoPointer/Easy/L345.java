package TwoPointer.Easy;

// 345. Reverse vowels of a String

public class L345 {

    public static boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' ||c == 'U')
            return true;
        return false;
    }

    public static String reverseVowel(String s){
        int i = 0, j = s.length()-1;
        char[] strArr = s.toCharArray();
        while(i <= j){
            if(!isVowel(strArr[i])){
                i++;
                continue;
            }
            if(!isVowel(strArr[j])){
                j--;
                continue;
            }
            if(isVowel(strArr[i]) && isVowel(strArr[j])){
                char temp = strArr[i];
                strArr[i] = strArr[j];
                strArr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(strArr);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowel(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)