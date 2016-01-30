public class Solution {
    public int minPathSum(int[][] grid) {
 		int m = grid.length;
 		int n = grid[0].length;

 		if (m == 0 && n == 0)
 			return 0;

 		int[][] board = new int[m][n];
 		board[0][0] = grid[0][0];
 		int i = 0, j = 0;

 		for (i = 1; i < n; i++) {
 			board[0][i] = grid[0][i] + board[0][i-1];
 		}     

 		for (i = 1; i < m; i++) {
 			board[i][0] = grid[i][0] + board[i-1][0];
 		}

 		for (i = 1; i < m; i++) {
 			for (j = 1; j < n; j++) {
 				if (board[i-1][j] > board[i][j-1]) {
 					board[i][j] = grid[i][j] + board[i][j-1];
 				} else {
 				    board[i][j] = board[i-1][j] + grid[i][j];
 				}
 			}
 		}

 		return board[m-1][n-1];
    }
}