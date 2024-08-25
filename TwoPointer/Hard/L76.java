package TwoPointer.Hard;

// 76. Minimum Window Substring

public class L76 {

    int NO_OF_CHARS = 256;

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return "";
        int[] hash_s = new int[NO_OF_CHARS];
        int[] hash_t = new int[NO_OF_CHARS];
        for(int i=0;i<n;i++){
            hash_t[t.charAt(i)]++;
        }

        int start = 0, startIndex = -1, minWindow = Integer.MAX_VALUE, count = 0;
        for(int i=0;i<m;i++){
            hash_s[s.charAt(i)]++;
            if(hash_t[s.charAt(i)] != 0 && hash_t[s.charAt(i)] >= hash_s[s.charAt(i)]){
                count++;
            }
            if(count == n){
                while(hash_t[s.charAt(start)] < hash_s[s.charAt(start)] || hash_t[s.charAt(start)] == 0){
                    if(hash_t[s.charAt(start)] < hash_s[s.charAt(start)]){
                        hash_s[s.charAt(start)]--;
                    }
                    start++;
                }
                int minLength = i-start+1;
                if(minLength < minWindow){
                    minWindow = minLength;
                    startIndex = start;
                }
            }
        }
        if(startIndex == -1)
            return "";
        return s.substring(startIndex, startIndex+minWindow);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        L76 obj = new L76();
        System.out.println(obj.minWindow(s, t));
    }
}

// Time Complexity - O(m+n)
// Space Complexity - O(1)