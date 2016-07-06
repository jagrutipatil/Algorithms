/**
* 	Search a 2D Matrix
* 	Write an efficient algorithm that searches for a value in an m x n matrix.
*
*	This matrix has the following properties:
*
*	Integers in each row are sorted from left to right.
*	The first integer of each row is greater than the last integer of the previous row.
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
        	return false;
        }
        int n = matrix[0].length, start = 0, end = 0, mid = 0, mx = 0, my = 0;
        end = m*n -1;

        while (start <= end) {
        	mid = (start + end)/2;
        	mx = (mid/n);
        	my = (mid%n);

        	if (matrix[mx][my] == target) {
        		return true;
        	} else if (matrix[mx][my] < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return false;
    }
}
