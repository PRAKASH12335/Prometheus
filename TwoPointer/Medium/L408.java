package TwoPointer.Medium;

public class L408 {
//    Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
//    Notice that only the above abbreviations are valid abbreviations of the string "word".
//    Any other string is not a valid abbreviation of "word".
//    Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
//
//    Example 1:
//    Given s = "internationalization", abbr = "i12iz4n"
//    Return true.
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int m = word.length(), n = abbr.length();
        while(i<m){
            if(j >= n)
                return false;
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            int k = j;
            while(k<n && Character.isDigit(abbr.charAt(k))){
                k++;
            }
            String t = abbr.substring(j, k);
            if(j == k || t.charAt(0) == '0' || Integer.parseInt(t) == 0){
                return false;
            }
            i += Integer.parseInt(t);
            j = k;
        }
        return i==m && j==n;
    }
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(validWordAbbreviation(word, abbr));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)