package DP.Medium;

// 5. Longest Palindromic Substring
// 647. Palindromic Substrings

public class L5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] palin = new boolean[n][n];
        int maxLen = 1, start = 0;
        for(int i=0;i<n;i++){
            palin[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                palin[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for(int k=3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(palin[i+1][j-1] == true && s.charAt(i) == s.charAt(j)){
                    palin[i][j] = true;
                    start = i;
                    if(maxLen < k){
                        maxLen = k;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        L5 obj = new L5();
        System.out.println(obj.longestPalindrome(s));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)