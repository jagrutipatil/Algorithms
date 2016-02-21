public class Solution {
    public void rotate(int[][] matrix) {
 		int m = matrix.length;

 		for (int i = 0; i < (m/2); i++) {
 			for (int j = 0; j < (Math.ceil((double)m/2.0)); j++) {
 				int temp = matrix[i][j];
 				matrix[i][j] = matrix[m-1-j][i];
 				matrix[m-1-j][i] = matrix[m-1-i][m-1-j];
 				matrix[m-1-i][m-1-j] = matrix[j][m-1-i];
 				matrix[j][m-1-i] = temp;
 			}
 		}       
    }
}