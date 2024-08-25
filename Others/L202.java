package Others;

// 202. Happy Number

import java.util.HashSet;
import java.util.Set;

public class L202 {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1){
            int num = n;
            int square = 0;
            while(num > 0){
                int remainder = num % 10;
                square += remainder * remainder;
                num = num/10;
            }
            if(seen.contains(square))
                return false;
            seen.add(square);
            n = square;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 19;
        L202 obj = new L202();
        System.out.println(obj.isHappy(n));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)