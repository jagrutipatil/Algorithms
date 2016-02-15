// Interleaving String

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