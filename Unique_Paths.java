/**
* Unique Paths
* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
*
* The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 
* 'Finish' in the diagram below).
*
* How many possible unique paths are there?
*
* Logic:
* This is simple math problem, there are total m-1 downward paths and n-1 side paths. we have to choose total turns taken out of m+n-2 to reach 
* destination. i.e select minimum of m-1. n-1 out of m+n-2
*
* Combination formula C(n,r) = n!/(r!*(n-r)!) = (n*(n-1)*..(n-r))/(1*2*..r)
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        return combination(m+n-2, Math.min(m-1, n-1));
    }

    public int combination(int m, int n) {
    	double result = 1;

    	for (int i = 1; i <= n ;i++) { 
    		result = result * m--/i;
    	}
    	return (int)result;
    }
}
