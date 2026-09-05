// class Solution {

//     public int totalNQueens(int n) {

//         char[][] board = new char[n][n];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(board[i], '.');
//         }

//         return solve(0, board, n);
//     }

//     public int solve(int col, char[][] board, int n) {

//         // All queens placed
//         if (col == n) {
//             return 1;
//         }

//         int count = 0;

//         for (int row = 0; row < n; row++) {

//             if (isSafe(row, col, board, n)) {

//                 board[row][col] = 'Q';

//                 count += solve(col + 1, board, n);

//                 board[row][col] = '.';
//             }
//         }

//         return count;
//     }

//     public boolean isSafe(int row, int col, char[][] board, int n) {

//         // Same row
//         for (int j = 0; j < col; j++) {
//             if (board[row][j] == 'Q') {
//                 return false;
//             }
//         }

//         // Upper-left diagonal
//         int i = row - 1;
//         int j = col - 1;

//         while (i >= 0 && j >= 0) {

//             if (board[i][j] == 'Q') {
//                 return false;
//             }

//             i--;
//             j--;
//         }

//         // Lower-left diagonal
//         i = row + 1;
//         j = col - 1;

//         while (i < n && j >= 0) {

//             if (board[i][j] == 'Q') {
//                 return false;
//             }

//             i++;
//             j--;
//         }

//         return true;
//     }
// }



class Solution {

    public int totalNQueens(int n) {

        boolean[] row = new boolean[n];

        boolean[] upperDiagonal = new boolean[2 * n - 1];

        boolean[] lowerDiagonal = new boolean[2 * n - 1];

        return solve(0, n, row, upperDiagonal, lowerDiagonal);
    }

    public int solve(int col, int n,
                     boolean[] row,
                     boolean[] upperDiagonal,
                     boolean[] lowerDiagonal) {

        // All queens placed
        if (col == n) {
            return 1;
        }

        int count = 0;

        for (int r = 0; r < n; r++) {

            int upper = r - col + n - 1;
            int lower = r + col;

            // Position not safe
            if (row[r] || upperDiagonal[upper] || lowerDiagonal[lower]) {
                continue;
            }

            // Place queen
            row[r] = true;
            upperDiagonal[upper] = true;
            lowerDiagonal[lower] = true;

            // Move to next column
            count += solve(col + 1, n,
                           row, upperDiagonal, lowerDiagonal);

            // Backtrack
            row[r] = false;
            upperDiagonal[upper] = false;
            lowerDiagonal[lower] = false;
        }

        return count;
    }
}