package TwoPointer.Easy;

// 2027. Minimum Moves to Convert String

public class L2027 {
    public int minimumMoves(String s) {
        int moves = 0, i =0;
        while(i < s.length()){
            if(s.charAt(i) == 'X'){
                moves++;
                i= i+3;
            }else
                i++;
        }
        return moves;
    }

    public static void main(String[] args) {
        String s = "XX0X";
        L2027 obj = new L2027();
        System.out.println(obj.minimumMoves(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)
