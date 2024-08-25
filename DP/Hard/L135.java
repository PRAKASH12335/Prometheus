package DP.Hard;

// 135. Candy

import java.util.Arrays;

public class L135 {

    public static int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        for(int i=1;i< ratings.length;i++){
            if(ratings[i-1] < ratings[i]){
                dp[i] = dp[i-1]+1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1] < ratings[i]){
                dp[i] = Math.max(dp[i], dp[i+1]+1);
            }
        }

        int ans = 0;
        for(int i=0;i<dp.length;i++){
            ans += dp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)