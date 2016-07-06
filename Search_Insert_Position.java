/**	
*	Search Insert Position
*	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were 
*	inserted in order.
*
*	You may assume NO duplicates in the array.	
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length-1, mid = 0;

        while (start <= end) {
        	mid = (start + end)/2;
        	if (A[mid] == target) {
        		return mid;
        	} else if (A[mid] < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }

        return start;
    }
}
