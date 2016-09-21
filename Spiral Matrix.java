/*
	Spiral Matrix

	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].

Logic: Take 4 variables m1, m2, n1, n2 denoting lower and upper boundries of matrix
	   once corresponding row is read, increase/ decrease respective counter

*/

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

__________________________________________________________

// simplified Solution

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
		int m1 = 0, n1 = 0;
		List<Integer> result = new ArrayList<Integer>();
				
		if (matrix.length == 0)
		    return result;
		    
		int m2 = matrix.length-1, n2 = matrix[0].length-1;

		while (m1 <= m2 && n1 <= n2) {
			for (int j = n1; j <= n2; j++) {
				result.add(matrix[m1][j]);
			}
			m1++;
            
			for (int i = m1; i <= m2; i++) {
				result.add(matrix[i][n2]);
			}
			n2--;
            
            if (m1 <= m2) {
                for (int j = n2; j>= n1; j--) {
				    result.add(matrix[m2][j]);
			    }
			    m2--;                
            }

            if (n1 <= n2) {
			    for (int i = m2; i >= m1; i--) {
				    result.add(matrix[i][n1]);
			    }
			    n1++;                
            }

		}

		return result;
    }
}