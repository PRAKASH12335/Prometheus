package BackTracking.Hard;

// 51. N-Queens

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51 {

    private static boolean isSafe(int row, int col, char[][] board){
        int i, j;
        for(i=0;i<board.length;i++){
            if(board[row][i] == 'Q')
                return false;
        }

        for(i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }

        for(i=row, j=col;j>=0 && i< board.length;i++,j--){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static boolean solveNQueensHelper2(int col, char[][] board){
        if(col >= board.length) {
            return true;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(i, col, board)){
                board[i][col] = 'Q';
                if(solveNQueensHelper2(col+1, board) == true)
                    return true;
                board[i][col] = '.';
            }
        }
        return false;
    }

    public static void solveNQueens2(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(a -> Arrays.fill(a, '.'));
        if(solveNQueensHelper2(0, board) == false){
            System.out.print("Solution does not exist");
            return;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return;
    }

    public static void solveNQueensHelper(int col, char[][] board, List<List<String>> ans, int[] left, int[] lowerDiagonal, int[] upperDiagonal) {
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i< board.length;i++){
                String s = new String(board[i]);
                temp.add(s);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int row=0;row< board.length;row++){
            if(left[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length-1 + col-row] == 0){
                board[row][col] = 'Q';
                left[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length-1 + col-row] = 1;
                solveNQueensHelper(col+1, board, ans, left, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';
                left[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length-1 + col-row] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(a -> Arrays.fill(a, '.'));
        int[] left = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];
        solveNQueensHelper(0, board, ans, left, lowerDiagonal, upperDiagonal);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
        solveNQueens2(n);
    }
}

// Time Complexity - O(n*n!)
// Space Complexity - O(n)