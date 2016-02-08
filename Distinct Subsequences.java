public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        
 		int[][] dp = new int[s.length()+1][t.length()+1];
 		int i = 0, j = 0;

 		for (i = 0; i < s.length()+1;i++) {
 			dp[i][0] = 1;
 		}

 		for (i = 1; i < s.length()+1; i++) {
 			for (j=1; j < t.length()+1; j++) {
 				if (s.charAt(i-1) == t.charAt(j-1)) {
 					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
 				} else {
 					dp[i][j] = dp[i-1][j];
 				}
 			}
 		}

 		return dp[s.length()][t.length()];
    }
}