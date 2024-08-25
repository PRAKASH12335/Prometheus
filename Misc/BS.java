package Misc;

// Amazon OA

import java.util.Arrays;
import java.util.stream.IntStream;

public class BS {

    private static boolean canRead(int[] pages, int days, int minPages){
        int daysTaken = 0;
        int pagesRead = 0;
        for(int i=0;i<pages.length;i++){
            if(pages[i] < minPages || pagesRead + minPages >= pages[i]){
                daysTaken++;
                pagesRead = 0;
            }else{
                while(pagesRead + minPages < pages[i]) {
                    pagesRead = pagesRead + minPages;
                    daysTaken++;
                }
                daysTaken++;
                pagesRead = 0;
            }
            if(daysTaken > days)
                return false;
        }
        return daysTaken <= days;
    }

    private static int minPages(int[] pages, int days){
        int n = pages.length;
        if(n > days)
            return -1;
        int low = 1;
        int high = IntStream.of(pages).max().getAsInt();

        while(low < high){
            int mid = low + (high - low)/2;
            if(canRead(pages, days, mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 4};
        int days = 7;
        System.out.println(minPages(nums, days));
    }
}
