package TwoPointer.Medium;

// 1759. Count Number of Homogenous Substrings

public class L1759 {

    public int countHomogenous(String s) {
        int start =0, end = 0, mod = 1000000007;
        int ans = 0;
        while(end < s.length()){
            while(start <= end && s.charAt(start) != s.charAt(end)){
                start++;
            }
            ans = (ans+end-start+1)%mod;
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abbcccaa";
        L1759 obj = new L1759();
        System.out.println(obj.countHomogenous(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)