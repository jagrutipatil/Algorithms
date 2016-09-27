/*
    Find Peak Element
    
    A peak element is an element that is greater than its neighbors.

    Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    You may imagine that num[-1] = num[n] = -∞.

    For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    Logic: to find a pick number there are multiple things to be considered
           1. Array can contain less than 3 elements
           2. we can find any peak using binary search
                2.1 if nums[mid-1] < nums[mid] < nums[mid+1] then peak will be in mid-end half
                2.2 if nums[mid-1] > nums[mid] > nums[mid+1] then peak will be in start-mid half
                2.3 if nums[mid-1] > nums[mid] < nums[mid+1] then peak can be in start-mid or mid-end, so we can search in any half bcz edge boundries are -infinity
*/ 

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
