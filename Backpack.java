/*
	Backpack

	Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

	If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

	You function should return the max size we can fill in the given backpack.

	Logic:

	We can use 1D array to perform the DP.

	d[j] = d[j] || d[j-A[i-1]].	
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean[] dp = new boolean[m+1];
        dp[0] = true;

        for (int i = 0; i < A.length; i++) {
        	for (int j = m; j >= 0; j--) {
        		if (j - A[i] >= 0 && dp[j-A[i]])
        			dp[j] = dp[j-A[i]];
        	}
        }

        for (int j = m; j >= 0; j--) {
        	if (dp[j])
        		return j;
        }
        return -1;
    }
}