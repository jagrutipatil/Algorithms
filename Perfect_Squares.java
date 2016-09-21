/*
	Perfect Squares

	Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

	Example
		Given n = 12, return 3 because 12 = 4 + 4 + 4
		Given n = 13, return 2 because 13 = 4 + 9
*/

public class Solution {
    public int numSquares(int n) {
 		int[] dp = new int[n+1];

 		for (int i = 0; i <= n; i++) {
 			dp[i] = i;
 			for (int j = 1; j*j <= i; j++) {
 				dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
 			}
 		} 
 		
 		return dp[n];
    }
}