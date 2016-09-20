/*
	Longest Increasing Continuous Subsequence

	Give an integer array，find the longest increasing continuous subsequence in this array.

	An increasing continuous subsequence:

	Can be from right to left or from left to right.
	Indices of the integers in the subsequence should be continuous.

	Logic: Use incresing and decreasing boolean variable to keep track of if sequence is increasing or decreasing
		   Always keep track of maximum length so far. 
*/


public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
    	if (A.length == 0)
    		return 0;

    	int prev = A[0];
    	boolean incr = true, decr = false;
    	int maxLength = 1, currLen = 1;
    	for (int i = 1; i < A.length; i++) {
    	    if (prev == A[i])
    	        currLen += 1;
    	        
    		if (prev < A[i]) {
    			if (incr) {
    				currLen += 1;
    			} else {
    				currLen = 2;
    				incr = true;
    				decr = false;
    			}
    		}

    		if (prev > A[i]) {
    			if (decr) {
    				currLen += 1;
    			} else {
    				currLen = 2;
    				decr = true;
    				incr = false;
    			}
    		}

    		prev = A[i];
    		maxLength = Math.max(maxLength, currLen);
    	}
    	return maxLength;
    }
}