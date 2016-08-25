/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Logic: use stack to store only incresing height and when next bar is lower than previous height calculate its area. 
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0, i = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (i <= heights.length) {
        	int no = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || no >= heights[stack.peek()]) {
            	stack.push(i);
            	i++;
            } else {
            	int h = heights[stack.pop()];
            	int w = stack.isEmpty()? i : i - 1 - stack.peek();
            	max = Math.max(max, h*w);
            }
        }

		return max;        
    }
}