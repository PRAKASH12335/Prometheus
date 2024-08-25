package BackTracking.Medium;

// 36. Valid Sudoku

import java.util.HashSet;

public class L36 {

    public static boolean isValidSudoku(char[][] board) {
        int m = board.length, n= board[0].length;
        HashSet<String> seen = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] != '.') {
                    if (!seen.add(board[i][j] + " present at row " + i) ||
                            !seen.add(board[i][j] + " present at col " + j) ||
                            !seen.add(board[i][j] + " present at " + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}

// Time Complexity - O(n*n)
// Space Complexity - O(n)