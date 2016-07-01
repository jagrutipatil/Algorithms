/**
*	Logic: Go in descreasing order
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
        	if (A[m-1] > B[n-1]) {
        		A[m+n-1] = A[m-1];
        		m--;
        	} else {
        		A[m+n-1] = B[n-1];
        		n--;
        	}
        }

        while (n > 0) {
        	A[m+n-1] = B[n-1];
        	n--;
        }
    }
}