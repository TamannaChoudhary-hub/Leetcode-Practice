class Solution {

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        return solve(0, board, n);
    }

    public int solve(int col, char[][] board, int n) {

        // All queens placed
        if (col == n) {
            return 1;
        }

        int count = 0;

        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, board, n)) {

                board[row][col] = 'Q';

                count += solve(col + 1, board, n);

                board[row][col] = '.';
            }
        }

        return count;
    }

    public boolean isSafe(int row, int col, char[][] board, int n) {

        // Same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {

            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }

        // Lower-left diagonal
        i = row + 1;
        j = col - 1;

        while (i < n && j >= 0) {

            if (board[i][j] == 'Q') {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}