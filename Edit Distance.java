public class Solution {
    public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m+1][n+1];
		int i = 0, j = 0;
        
        if (word1 == null && word2 == null) {
            return 0;
        } else if (word1.equals(word2)) {
            return 0;
        } else if (m == 0) {
            return n;
        } else if (m == 0) {
            return n;
        } else if (m == 1 && n ==1) {
            return 1;
        }
            
		for (i = 0; i < m+1; i++) {
			dp[i][0] = i; 
		}       

		for (j = 0; j < n+1; j++) {
			dp[0][j] = j; 
		}       

		for (i = 1; i <=m; i++) {
			for (j=1; j <=n; j++) {
				if (word1.charAt(i-1) != word2.charAt(j-1)) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				} else {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		return dp[m][n];
    }
}