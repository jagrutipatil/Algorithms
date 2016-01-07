public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length, n = matrix[0].length;

 		if (target < matrix[0][0] || target > matrix[m-1][n-1])
 			return false;

 		int start = 0, end = m*n-1, mid = 0;
 		int midx = 0, midy = 0;

 		while (start <=end) {
 			mid = (start+end)/2 ;
 			midx = mid/n;
 			midy = mid%n;

 			if (matrix[midx][midy] == target)
 				return true;

 			if (matrix[midx][midy] < target) {
 				start = mid+1;
 			} 

 			if (matrix[midx][midy] > target){
 				end = mid-1;
 			}
 		}

 		return false;       
    }
}