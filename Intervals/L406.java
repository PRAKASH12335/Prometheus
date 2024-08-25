package Intervals;

// 406. Queue Reconstruction by Height

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0] - a[0]);

        // after sorting - [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
        List<int[]> result = new ArrayList<>();
        for(int[] person : people){
            result.add(person[1], person);
        }
        // Adding logic to result
        // [7,0]
        // [7,0],[7,1]
        // [7,0],[6,1],[7,1]
        // [5,0],[7,0],[6,1],[7,1]
        // [5,0],[7,0],[5,2],[6,1],[7,1]
        // [5,0],[7,0],[5,2],[6,1],[4,4],[7,1]
        // result - [5,0],[7,0],[5,2],[6,1],[4,4],[7,1]
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        L406 obj = new L406();
        int[][] result = obj.reconstructQueue(people);
        for(int i=0;i< people.length;i++) {
            Arrays.stream(result).forEach(a -> System.out.print(a + " "));
        }
    }
}

// Time Complexity - O(N*logN)
// Space Complexity - O(1)
