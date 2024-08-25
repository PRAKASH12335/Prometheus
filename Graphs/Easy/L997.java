package Graphs.Easy;

//  Find the town Judge

public class L997 {

    public static int findJudge(int n, int[][] trust){
        int[] arr = new int[n+1];
        for(int[] t : trust){
            arr[t[0]]--;
            arr[t[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(arr[i] == n-1)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3}};
        int n = 3;
        System.out.println(findJudge(n, trust));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)