public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if (matrix.length == 0)
    		return 0;

 		int m = matrix.length;
 		int n = matrix[0].length;
 		int[] row = new int[n];
 		int maxArea = 0;

 		for (int i = 0; i < m; i++) {
 			for (int j = 0; j < n; j++) {
 				if (matrix[i][j] !=  '0') {
 					row[j] = row[j] + 1;
 				} else {
 				 	row[j] = 0;
 				}
 			}
 			maxArea = Math.max(maxArea, calculateArea(row));
 		}
 		return maxArea;
    }
    
    
    int calculateArea(int[] row) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int max = row[0], n = row.length, i = 0;
    	while (i < n) {
    		if(stack.isEmpty() || row[i] >= row[stack.peek()]) {
    			stack.push(i);
    			i++;
    		} else {
    			int index = stack.pop();
    			int h = row[index];
    			int w = stack.isEmpty() ? i: i - stack.peek() - 1;
    			max = Math.max(max, h*w);
    		} 
    	}
    	
    	while (!stack.isEmpty()) {
    	    int index = stack.pop();
    		int h = row[index];
    		int w = stack.isEmpty() ? i: i - stack.peek() -1 ;
    		max = Math.max(max, h*w);
    	}
    	return max;
    }
}