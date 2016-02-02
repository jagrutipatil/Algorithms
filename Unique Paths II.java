public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int i = 0, j = 0;
        
        if (m==1 && n == 1 && obstacleGrid[0][0] == 0) 
            return 1;
        else if (obstacleGrid[0][0] == 1)
            return 0;

 		int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
 		for (i = 1; i < m; i++) {
 			if (obstacleGrid[i][0] != 1 && dp[i-1][0] != 0) {
 				dp[i][0] = 1;
 			} else {
 				dp[i][0] = 0;
 			}
 		}      

 		for (i = 1; i < n; i++) {
 			if (obstacleGrid[0][i] != 1 && dp[0][i-1] != 0) {
 				dp[0][i] = 1;
 			} else {
 				dp[0][i] = 0;
 			}
 		}

 		for (i = 1; i < m; i++) {
 			for (j = 1; j < n; j++) {
 				if (obstacleGrid[i][j] != 1) {
 					dp[i][j] = dp[i-1][j] + dp[i][j-1];
 				} else {
 					dp[i][j] = 0;
 				}

 			}
 		}

 		return dp[m-1][n-1];

    }
}