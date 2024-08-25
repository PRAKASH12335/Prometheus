package Striver.DP;

// DP 52. Evaluate Boolean Expression to True
public class DP52 {

    public static long helper(String exp, int i, int j, int isTrue) {
        if(i > j) return 0;
        if(i == j){
            if(isTrue == 1)
                return exp.charAt(i) == 'T' ? 1 : 0;
            else
                return exp.charAt(i) == 'F' ? 1 : 0;
        }
        long ways = 0;
        for(int ind=i+1;ind<=j-1;ind=ind+2){
            long lT = helper(exp, i, ind-1, 1);
            long lF = helper(exp, i, ind-1, 0);
            long rT = helper(exp, ind+1, j, 1);
            long rF = helper(exp, ind+1, j, 0);
            char operator = exp.charAt(ind);
            if(operator == '&'){
                if(isTrue == 1){
                    ways = (ways + lT*rT);
                }else{
                    ways = (ways + lT*rF + lF*rF + lF*rT);
                }
            }else if(operator == '|'){
                if(isTrue == 1){
                    ways = (ways + lT*rF + lF*rF + lF*rT);
                }else{
                    ways = (ways + lF*rF);
                }
            }else {
                if (isTrue == 1) {
                    ways = (ways + lF * rT + lT * rF);
                } else {
                    ways = (ways + lF * rF + lT * rT);
                }
            }
        }
        return ways;
    }

    public static int evaluateExpWays(String exp) {
        int n = exp.length();
        return (int)helper(exp, 0, n-1, 1);
    }

    public static void main(String[] args) {
        String exp = "F|T^F";
        int ways = evaluateExpWays(exp);
        System.out.println(ways);
    }
}
