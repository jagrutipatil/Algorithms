public class Solution {
    public void setZeroes(int[][] matrix) {
 		int k = 0, i, j;
 		int m = matrix.length;
 		int n = matrix[0].length;

 		while (k < n && matrix[0][k] != 0) k++;

 		for (i = 1; i < m; i++) {
 			for (j = 0; j < n; j++) {
 				if (matrix[i][j] == 0) {
 					matrix[0][j] = 0; matrix[i][0] = 0;
 				}
 			}
 		}

 		for (i = 1; i < m; i++) {
 			for (j = n-1; j>=0; j--) {
 				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
 					matrix[i][j] = 0;
 				}
 			}
 		}

 		if (k < n) {
 			Arrays.fill(matrix[0], 0);
 		}

    }
}