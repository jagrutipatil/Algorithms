/*
Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

e.g: n=9, return 10.

Logic: 1. Just multiply 2,3,5 with previous ugly numbers and pick minimum as next ugly number. Keep track of 2,3,5's multiplier with i,j,k pointers to alreaddy calculated ugly numbers
	   2. multyplying previously calculted ugly number will result in ugly number only. 
	   3. Note we need only numbers those have factors 2,3,5.
	   	  e.g: 14 is not ugly number because its factors are 2*7. So to find minimum each time we can not multiply 1,2,...n incrementing sequentially to 2,3,5 bcz it will add unwanted extra factors

*/
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