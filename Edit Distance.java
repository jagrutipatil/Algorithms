/*
Edit Distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:
 - Insert a character
 - Delete a character
 - Replace a character

Example
Given word1 = "mart" and word2 = "karma", return 3.

Logic:
	1. if characters are similar that means you just have to take minimum steps as a carry over from previous step i.e dp[i-1][j-1]
	2. if characters are different- you have to consider all possiblities by which you can get the minimum count, i.e dp[i-1][j], dp[i-1][j-1], dp[i][j-1]

*/
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