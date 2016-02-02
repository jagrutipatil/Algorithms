public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
            
        if (matrix.length == 1 && matrix[0].length == 1)    
            return matrix[0][0] - '0';
            
 		int m = matrix.length;
 		int n = matrix[0].length;
 		int i = 0, j = 0;
 		int[][] dp = new int[m][n];
        int max = dp[0][0];
        
 		for (i = 0; i < m; i++) {
 			if (matrix[i][0] == '1') {
 				dp[i][0] = 1;
 				max = 1;
 			}
 		}       

 		for (j = 0; j < n; j++) {
 			if (matrix[0][j] == '1') {
 				dp[0][j] = 1;
 				max = 1;
 			}
 		}

 		
 		for (i = 1 ; i < m; i++) {
 			for (j = 1; j < n; j++) {
 				if (matrix[i][j] == '1') {
 					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
 					max = Math.max(max, dp[i][j]);
 				}
 			}
 		}
 		return max*max;
    }
}