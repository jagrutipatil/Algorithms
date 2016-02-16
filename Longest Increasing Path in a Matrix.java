public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
 		int m = matrix.length;

 		if (m == 0)
 			return 0;
 		int n = matrix[0].length;
 		int[][] visited = new int[m][n];
 		int len = 0;

 		for (int i = 0; i < m; i++) {
 			for (int j = 0; j < n; j++) {
 				len = Math.max(calcLen(i, j, matrix, visited, Integer.MIN_VALUE), len);
 			}
 		}

 		return len;       
    }

    int calcLen(int i, int j, int[][] matrix, int[][] visited , int prev) {
    	if ( i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || prev >= matrix[i][j]) {
    		return 0;
    	}

    	if (visited[i][j] > 0) {
    		return visited[i][j];
    	}
    	
    	int tempLen = 0;
    	tempLen = Math.max(calcLen(i, j+1, matrix, visited, matrix[i][j]), tempLen);
    	tempLen = Math.max(calcLen(i, j-1, matrix, visited, matrix[i][j]), tempLen);
    	tempLen = Math.max(calcLen(i+1, j, matrix, visited, matrix[i][j]), tempLen);
    	tempLen = Math.max(calcLen(i-1, j, matrix, visited, matrix[i][j]), tempLen);
    	visited[i][j] = ++tempLen;
    	return tempLen;
    }
}