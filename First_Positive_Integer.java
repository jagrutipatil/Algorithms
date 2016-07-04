/**
* First Missing Positive
*
* Given an unsorted integer array, find the first missing positive integer.
*
* Logic: if non positive or out of the index number then ignore it else put it at its right place (if A[i] = x then it sould be at A[x-1])
*
*
* Given a number in the array,
*
*	1. 	if it is non-positive, ignore it;
*	2. 	if it is positive, say we have A[i] = x, we know it should be in slot A[x-1]! That is to say, we can swap A[x-1] with A[i] so as to place *	  x into the right place.
*
*	We need to keep swapping until all numbers are either non-positive or in the right places. The result array could be something like [1, 2, 3, 
*    0, 5, 6, ...]. Then it's easy to tell that the first missing one is 4 by iterate through the array and compare each value with their index.
*
**/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        int i = 0;
        
        while (i < A.length) {
        	if (A[i] <= 0 || A[i]-1 > A.length || A[i]-1 == i || (A[i] -1 < A.length && A[A[i] -1] == A[i])) {
        		i++;
        		continue;
        	} else {
        		int t = A[i];
        		A[i] = A[t-1];
        		A[t-1] = t;
        	}
        }

        for (i = 0; i < A.length; i++) {
        	if (A[i]-1 != i)
        		return i+1;
        }

        return A.length + 1;
    }
}