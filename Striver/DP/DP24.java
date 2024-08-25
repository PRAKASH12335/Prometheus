package Striver.DP;

import java.util.Arrays;

public class DP24 {

    //Recursion
    public static int cutRodHelper(int price[], int index, int n) {
        if(index == 0){
            return price[0]*n;
        }
        int notCut = cutRodHelper(price, index-1, n);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;
        if(rod_length<=n)
            cut = price[index] + cutRodHelper(price, index, n-rod_length);
        return Math.max(notCut, cut);
    }

    public static int cutRod(int price[], int n) {
        return cutRodHelper(price, price.length-1, n);
    }

    //Memoization
    public static int cutRodMemoHelper(int price[], int index, int n, int[][] dp) {
        if(index == 0){
            return price[0]*n;
        }
        if(dp[index][n] != -1)
            return dp[index][n];
        int notCut = cutRodMemoHelper(price, index-1, n, dp);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;
        if(rod_length<=n)
            cut = price[index] + cutRodMemoHelper(price, index, n-rod_length, dp);
        return dp[index][n] = Math.max(notCut, cut);
    }

    public static int cutRodMemo(int price[], int n) {
        int[][] dp = new int[price.length][price.length+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return cutRodMemoHelper(price, price.length-1, n, dp);
    }

    public static int cutRodDP(int price[], int n) {
        int[][] dp = new int[price.length][price.length+1];
        for(int i=0;i<= price.length;i++){
            dp[0][i] = i*price[0];
        }
        for(int i=1;i< price.length;i++){
            for(int j=0;j<= price.length;j++){
                int notCut = dp[i-1][j];
                int cut = Integer.MIN_VALUE;
                int rod_length = i + 1;
                if(rod_length<=j)
                    cut = price[i] + dp[i][j-rod_length];
                dp[i][j] = Math.max(notCut, cut);
            }
        }
        return dp[price.length-1][price.length];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(cutRod(arr, arr.length));
        System.out.println(cutRodMemo(arr, arr.length));
        System.out.println(cutRodDP(arr, arr.length));
    }
}
