package String.Easy;

// 28. Find the Index of the First Occurrence in a String

public class L28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if(n > m)
            return -1;

        for(int i=0;i<m - n;i++){
            int j = 0;
            while(j < n && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == n)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        L28 obj = new L28();
        System.out.println(obj.strStr(haystack, needle));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)
