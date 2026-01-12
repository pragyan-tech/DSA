class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(i,j,board,c)) {
                            board[i][j] = c; 

                            if (solve(board)) return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int column, char[][] board, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == c)
                return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c)
                return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[3 * (row / 3) + i][3 * (column / 3) + j] == c)
                    return false;
            }
        }
        return true;
    }
}