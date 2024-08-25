package Others;
//Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//Since the result may be very large, so you need to return a string instead of an integer.
//Example 1:
//Input: nums = [10,2]
//Output: "210"

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class CustomComparator implements Comparator<String>{

    @Override
    public int compare(String a, String b){
        String order1 = a+b;
        String order2 = b+a;
        return order2.compareTo(order1);
    }
}
public class L179 {

    public static String largestNumberwithStreams(int[] nums) {
//        final String s = Arrays.stream(nums)
//                .mapToObj(String::valueOf)
//                .sorted((a,b) -> (b+a).compareTo(a+b))
//                .collect(Collectors.joining(""));
//        return s.startsWith("00") ? "0" : s;

        final String str = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a,b) -> (b+a).compareTo(a+b)).collect(Collectors.joining());
        return str.startsWith("00") ? "0" : str;
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return "";
        String[] strs = new String[n];
        for(int i=0;i<n;i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new CustomComparator());
        if(strs[0].charAt(0) == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));
        System.out.println(largestNumberwithStreams(nums));
    }
}


// Time Complexity - O(nlogn)
// Time Complexity - O(n)