package BackTracking.Medium;

// 79. Word Search

public class L79 {

    public static boolean dfs(char[][] board, int row, int col, int count, String word){

        if(count == word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(count) != board[row][col] || board[row][col] == '*')
            return false;
        char temp = board[row][col];
        board[row][col] = '*';
        boolean found = dfs(board, row+1, col, count+1, word) ||
                dfs(board, row, col+1, count+1, word) ||
                dfs(board, row, col-1, count+1, word) ||
                dfs(board, row-1, col, count+1, word);
        board[row][col] = temp;
        return found;
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}

// Time Complexity - O(mn4^∣word∣)
// Space Complexity - O(4^|word|)