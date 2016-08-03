/*
 N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Logic:
each row will have 1 queen, so recursively validate each column for each row
validation logic: 
1. each column can have one queen
2. valid position (queens[i][j]) is which does not have any queen in 45 degree angle and 135 degree angle from queens[i][j]
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n == 0)
            return result;

        char[][] queens = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(queens[i], '.');
        }
        buildBoard(result, queens, n, 0);
        return result;
    }

    void buildBoard(ArrayList<ArrayList<String>> result, char[][] queens, int n, int row) {
        if (n == row) {
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                list.add(new String(queens[i]));
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(queens, i, row, n)) {
                queens[row][i] = 'Q';
                buildBoard(result, queens, n, row + 1);
                queens[row][i] = '.';
            }
        }
    }

    boolean isValid(char[][] queens, int col, int row, int n) {
        //check straight column
        for (int i=0; i < row; i++) {
            if (queens[i][col] == 'Q')
                return false;
        }

        //check 45 degree
        for (int i = row -1, j = col-1; i>=0 && j>=0; i--, j--) {
            if (queens[i][j] == 'Q') {
                return false;
            }
        }

        //check 135 degree
        for (int i = row-1, j = col +1; i>=0 && j < n; j++, i--) {
            if (queens[i][j] == 'Q') {
                return false;
            }   
        }
        return true;
    }
};