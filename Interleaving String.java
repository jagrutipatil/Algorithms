// Interleaving String

/*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Logic: use dynamic programming. 
		DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position. 0th position means empty string.

		So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. If only s1 is empty, then if previous s2 position is interleaving and current s2 position char is equal to s3 current position char, it is considered interleaving. similar idea applies to when s2 is empty. when both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal, it s interleaving. If we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position equal. it is interleaving.


*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length();

		if (m+n != s3.length())
			return false;

		boolean[][] dp = new boolean[m+1][n+1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				int k = i+j;

				if (k == 0) {
					dp[i][j] = true;
					continue;
				}

				if (i > 0 && s1.charAt(i-1) == s3.charAt(k-1)) {
					dp[i][j] = dp[i][j] | dp[i-1][j];
				}

				if (j > 0 && s2.charAt(j-1) == s3.charAt(k-1)) {
					dp[i][j] = dp[i][j] | dp[i][j-1];
				}
			}
		}
		
		return dp[m][n];     
    }
}