package String.Medium;

// 1750. Minimum Length of String After Deleting Similar Ends

public class L1750 {
    private int removePrefixSuffix(String s){
        int start = 0, end = s.length()-1;
        while(start < end && s.charAt(start) == s.charAt(end)){
            char c = s.charAt(start);
            while(start <= end && s.charAt(start) == c){
                start++;
            }
            while(start < end && s.charAt(end) == c){
                end--;
            }
        }
        return end-start+1;
    }

    public static void main(String[] args) {
        String s = "aabccabba";
        L1750 obj = new L1750();
        System.out.println(obj.removePrefixSuffix(s));
    }
}

// Time Complexity - 0(N)
// Space Complexity - 0(1)