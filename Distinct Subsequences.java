/*
As a typical way to implement a dynamic programming algorithm, we construct a matrix dp, where each cell dp[i][j] represents the number of solutions of aligning substring T[0..i] with S[0..j];

Rule 1). dp[0][j] = 1, since aligning T = "" with any substring of S would have only ONE solution which is to delete all characters in S.

Rule 2). when i > 0, dp[i][j] can be derived by two cases:

case 1). if T[i] != S[j], then the solution would be to ignore the character S[j] and align substring T[0..i] with S[0..(j-1)]. Therefore, dp[i][j] = dp[i][j-1].

case 2). if T[i] == S[j], then first we could adopt the solution in case 1), but also we could match the characters T[i] and S[j] and align the rest of them (i.e. T[0..(i-1)] and S[0..(j-1)]. As a result, dp[i][j] = dp[i][j-1] + d[i-1][j-1]

e.g. T = B, S = ABC

dp[1][2]=1: Align T'=B and S'=AB, only one solution, which is to remove character A in S'.

*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
    	int m = T.length();
    	int n = S.length();
        
        if (n < m)
            return 0;
            
    	int[][] dp = new int[m+1][n+1];
    	for (int i = 0; i < n+1; i++) {
    		dp[0][i] = 1;
    	}

    	for (int i = 1; i < m+1; i++) {
    		for (int j = 1; j < n+1; j++) {
    			if (S.charAt(j-1) != T.charAt(i-1)) {
    				dp[i][j] = dp[i][j-1];
    			} else {
    				dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
    			}
    		}
    	}
    	return dp[m][n];
    }
}