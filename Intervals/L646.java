package Intervals;

import java.util.Arrays;

public class L646 {

    // Similar to L485

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1]-b[1]);
        int count = 1;
        int end = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(end < pairs[i][0]){
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs));
    }
}

// Time Complexity - O(nlogn)
// Space Complexity - 0(1)