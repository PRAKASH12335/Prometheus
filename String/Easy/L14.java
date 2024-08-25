package String.Easy;

// 14. Longest Common prefix

import java.util.Arrays;

public class L14 {

    public static String longCommonPrefix(String[] strs){
        Arrays.sort(strs);
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            if(strs[n-1].charAt(i) != strs[0].charAt(i))
                return sb.toString();
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longCommonPrefix(strs));
    }
}


// Time Complexity - O(N Log N)
// Space Complexity - O(N)