package Misc;

// B17. Aggressive cows

import java.util.Arrays;

public class BS17 {

    private boolean canWePlace(int[] stall, int dist, int cows){
        int cntCows = 1, last = stall[0];
        for(int i=1;i<stall.length;i++){
            if(stall[i] - last >= dist){
                cntCows++;
                last = stall[i];
            }
            if(cntCows >= cows){
                return true;
            }
        }
        return false;
    }
    private int aggressiveCows(int[] stall, int cows){
        Arrays.sort(stall);
        int low = 1, high = stall[stall.length-1] - stall[0];

        while(low <= high){
            int mid = (low+high)/2;
            if(canWePlace(stall, mid, cows) == true){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] stall = {0,3,4,7,9,10};
        int cows = 4;
        BS17 obj = new BS17();
        System.out.println(obj.aggressiveCows(stall, cows));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)