package DP.Hard;

// 1092. Shortest Common Supersequence
// Steps :
// 1. Find LCS
// 2. Iterate LCS DP and find the string

public class L1092 {

    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;
        for(int j=0;j<=n;j++)
            dp[0][j] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = m, j = n;
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--; j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }
}


// Time Complexity - O(M*N)
// Space Complexity - O(M*N)