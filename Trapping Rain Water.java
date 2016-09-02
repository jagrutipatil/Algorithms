/*
	Trapping Rain Water

	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	Example
			Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

	Logic:
			1. Instead of calculating area by height*width, we can think it in a cumulative way. In other words, sum water amount of each bin(width=1).

			2. Search from left to right and maintain a max height of left and right separately, which is like a one-side wall of partial container. Fix the higher one and flow water from the lower part. For example, if current height of left is lower, we fill water in the left bin. Until left meets right, we filled the whole container.
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int left = 0, right = heights.length - 1;
        int leftMax = 0, rightMax = 0, result = 0;

        while (left < right) {
        	if (heights[left] <= heights[right]) {
        		if (heights[left] >= leftMax) {
        			leftMax = heights[left];
        		} else {
        			result += leftMax - heights[left];
        		}
        		left++;
        	} else {
        		if (heights[right] >= rightMax) {
        			rightMax = heights[right];
        		} else {
        			result += rightMax - heights[right];
        		}
        		right--;
        	}
        }
        return result;
    }
}