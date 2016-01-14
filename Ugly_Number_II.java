public class Solution {
    public int nthUglyNumber(int n) {
 		int[] dp = new int[n];
 		int i = 0, j = 0, k = 0;

 		dp[0] = 1;
 		for (int m = 1; m < n; m++) {
 			dp[m] = Math.min(Math.min(dp[i]*2, dp[j]*3), dp[k]*5);
 			if (dp[m] == dp[i]*2) i++;
 			if (dp[m] == dp[j]*3) j++;
 			if (dp[m] == dp[k]*5) k++;
 		}        
 		return dp[n-1];
    }
}