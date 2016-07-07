
/**
* Complexity O(n)
*/
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
    	int curr = 0, prev = 0, next = 0;
    	for (int i = 1; i < A.length -1 ; i++) {
    		curr = A[i];
    		prev = A[i-1];
    		next = A[i+1];

    		if (prev < curr && curr > next) {
    			reuturn i;
    		}
    	}
    	return -1;
    }
}

//____________________________________________

/**
* Complexity O(log n)
* Assumption: at least one peak element exists
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1, mid = 0;
        
        while (start +1 < end) {
            mid = (start+end)/2;
            if (A[mid] < A[mid-1]) {
                end = mid;
            } else if (A[mid] < A[mid+1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
