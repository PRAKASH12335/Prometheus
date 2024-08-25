package DP.Medium;

public class L343 {

    public static int power(int x, int y){
        if(y == 0)
            return 1;
        if(y%2 == 0)
            return power(x, y/2)*power(x, y/2);
        else
            return x*power(x, y/2)*power(x, y/2);
    }
    public static int integerBreak(int n) {
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int maxProduct=0;
        switch(n%3){
            case 0 : maxProduct = power(3,(int)n/3);
                break;
            case 1 : maxProduct = 4*power(3,(int)n/3-1);
                break;
            case 2 : maxProduct = 2*power(3,(int)n/3);
                break;
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(integerBreak(n));
    }
}

// Time Complexity - O(1)
// Space Complexity - 0(1)