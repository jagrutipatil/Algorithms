public class Solution {
    Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
 		if (board == null || board.length == 0)       
 			return;

 		int m = board.length;
 		int n = board[0].length;

 		for (int i = 0; i < m; i++) {
 			if (board[i][0] == 'O') 
 				markHash(board, i, 0);

 			if (board[i][n-1] == 'O') 
 				markHash(board, i, n-1);
 		}

 		for (int j = 0; j < n; j++) {
 			if (board[0][j] == 'O')
 			   markHash(board, 0, j);

 			if (board[m-1][j] == 'O')
 				markHash(board, m-1, j);
 		}

 		for (int i = 0; i < m; i++) {
 			for (int j = 0; j < n; j++) {
 				if (board[i][j] == 'O') {
 					board[i][j] = 'X'; 
 				} else if (board[i][j] == '#') {
 					board[i][j] = 'O';
 				} 					
 			}
 		}
    }

    void markHash(char[][] board, int i, int j) {
    	int m = board.length;
    	int n = board[0].length;

        fillTheSpot(board, i, j);
    	while (queue.size() > 0) {
    		int val = queue.poll();
    		int x = val / n;
    		int y = val % n;
    		fillTheSpot(board, x, y+1);
    		fillTheSpot(board, x, y-1);
    		fillTheSpot(board, x+1, y);
    		fillTheSpot(board, x-1, y);
    	}
    }

    void fillTheSpot(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        
    	if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
    		return;
    	}

    	board[i][j] = '#';
    	queue.offer(i*n + j);
    }
}