/*
Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Logic: Use bottom up approach
        Take arrayof size number of rows in triangle i.e it will be equivalent to number count in last row, 
        go on selecting minimum at each stage until you reach top.

*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle.size() == 0)
    		return 0;

    	int[] target = new int[triangle.size()];
    	
    	for (int i = 0; i < triangle.size(); i++) {
    	    target[i] =  triangle.get(triangle.size()-1).get(i);
    	}

    	for (int i = triangle.size() -2 ; i >=0 ; i--) {
    		for (int j = 0; j < triangle.get(i).size(); j++) {
    			target[j] = triangle.get(i).get(j) + Math.min(target[j], target[j+1]);
    		}
    	}
    	return target[0];
    }
}