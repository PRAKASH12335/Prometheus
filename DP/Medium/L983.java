package DP.Medium;

//Minimum Cost For Tickets

import java.util.HashSet;

public class L983 {

    public static int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> seen = new HashSet<>();
        int max = days[days.length-1];
        int[] dp = new int[max+1];
        for(int day : days){
            seen.add(day);
        }

        for(int i=1;i<dp.length;i++){
            int c1 = dp[i-1];
            int c7 = (i-7)>0 ? dp[i-7] : 0;
            int c30 = (i-30)>0 ? dp[i-30] : 0;
            if(seen.contains(i)){
                dp[i] = Math.min(c1+costs[0], Math.min(c7+costs[1], c30+costs[2]));
            }else
                dp[i] = dp[i-1];
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] costs = new int[]{2,7,15};
        int[] days = new int[]{1,4,6,7,8,20};
        System.out.println(mincostTickets(days, costs));
    }
}

// Time complexity - O(N), N = length of days
// Space complexity - O(N),