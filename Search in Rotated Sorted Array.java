public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
    	int start = 0, end = A.length -1 , mid = 0;

    	while (start <= end) {
    		mid = (start + end)/2;

    		if (A[mid] == target) {
    			return mid;
    		} 

    		if (A[start] < A[mid]) {
    			if (A[start] <= target && target < A[mid]) {
    				end = mid -1;
    			} else {
    				start = mid + 1;
    			}
    		} else {
    			if (  A[mid] < target && target <= A[end]) {
    				start = mid + 1;
    			} else {
    				end = mid - 1;
    			}
    		}
    	}
    	return -1;
    }
}
