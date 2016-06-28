public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	int m = A.length(), n = B.length();

    	if (m == 0 || n == 0) 
    		return 0;    	

        int[][] dp = new int[m+1][n+1];
        int result = 0;

        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (A.charAt(i-1) == B.charAt(j-1)) {
        			dp[i][j] = 1 + dp[i-1][j-1];
        			result = Math.max(result, dp[i][j]);
        		} else {
        			dp[i][j] = 0;
        		}
        	}
        }
        return result;
    }
}