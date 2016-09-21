/*
    Search a 2D Matrix II

    Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

    This matrix has the following properties:

    Integers in each row are sorted from left to right.
    Integers in each column are sorted from up to bottom.
    No duplicate integers in each row or column.

    Logic:
            Compare target with last value in first row, if target is less than the value, we can avoid the last column as values in column are in ascending order, similarly if the value is greater, we can avoid the current row
            if target is equal to value, increment the counter and increment currentrow and column as no duplicates in any row and column.
*/
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
    	int count = 0;

    	if (matrix.length == 0)
    		return count;

    	int i = 0, j = matrix[0].length-1;
    	while (i < matrix.length && j>= 0) {
    		if (target < matrix[i][j]) {
    			j--;
    		} else if (target > matrix[i][j]) {
				i++;
			} else if (target == matrix[i][j]) {
    			count++;
    			i++;
    			j--;
    		}
    	}
    	return count;
    }
}
