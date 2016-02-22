public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
 		int m = matrix.length;
 		List<Integer> result = new ArrayList<Integer>();

 		if (m == 0)
 			return result;

 		int n = matrix[0].length;
 		int k = 0, l = 0, i = 0;

 		while (k < m && l < n) {
 			//first row
 			for (i = l; i < n; i++) {
 				result.add(matrix[k][i]);
 			}
 			k++;

 			//last column
 			for (i = k; i < m; i++) {
 				result.add(matrix[i][n-1]);
 			}
 			n--;
            
            if (k < m) {
                //last row
 			    for (i = n-1; i>= l; i--) {
 				    result.add(matrix[m-1][i]);
 			    }
 			    m--;    
            }

 			if (l < n) {
 				//first column
 				for (i = m-1; i>=k ; i--) {
 					result.add(matrix[i][l]);
 				}
 				l++;
 			}
 		}
 		return result;
    }
}