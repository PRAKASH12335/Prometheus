package Graphs.Medium;

// 130. Surrounded Regions

public class L130 {

    public static void dfs(int row, int col, char[][] board, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] == 'X' || board[row][col] == '#')
            return;
        board[row][col] = '#';
        dfs(row-1, col, board, m, n);
        dfs(row, col-1, board, m, n);
        dfs(row+1, col, board, m, n);
        dfs(row, col+1, board, m, n);
    }

    public static void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && board[i][j] == 'O'){
                    dfs(i, j, board, m, n);
                }
            }
        }
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        solve(board);
        for(int i=0;i< board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Time complexity - O(M*N)
// Space complexity - O(M*N)