public class Solution {
    public int[][] generateMatrix(int n) {
 		int[][] matrix = new int[n][n];
 		int i = 0, l = 0, k = 0, count = 1;
 		int m = n, limit = n*n;

 		while (k < n && l < m) { 			
 		    
 			//first row
            for (i = k; i < n; i++) {
 				matrix[l][i] = count++;
 			}
 			l++; 			

 	 		//last column
 			for (i = l; i < m ; i++) {
 				 matrix[i][n-1] = count++;
 			}
 			n--;

 			//last row (<---)
 			if (l < m) {
                for (i = n-1; i >= k; i--) {
 				     matrix[m-1][i] = count++;
 			    }
 			    m--;
 			}

 			//first column
 			if (k < n) {
 			  for (i = m-1; i >= l; i--) {
 			       matrix[i][k] = count++;
 			  }
 			  k++; 			
 			}
 		}
 		return matrix;
    }
}