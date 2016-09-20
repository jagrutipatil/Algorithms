/*
	Backpack II

	Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

	Example
			Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length == 0 || V.length == 0 || A.length != V.length || m <= 0) {
    		return 0;
    	}
    	int row = A.length+1;
    	int col = m+1;
    	int[][] dp = new int[row][col];
        dp[0][0] = 0;
        
    	for (int i = 1; i <= A.length; i++) {
    		for (int j = 0; j <= m; j++) {
    			if (A[i-1] > j) {
    				dp[i][j] = dp[i-1][j];
    			} else {
    				dp[i][j] = Math.max(V[i-1] + dp[i-1][j-A[i-1]], dp[i-1][j]);
    			}
    		}
    	}
    	return dp[row-1][col-1];
    }
}