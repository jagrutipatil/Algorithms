/*
Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Example
Given [1,3,2], the max area of the container is 2.

Logic:

The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.
All other containers are less wide and thus would need a higher water level in order to hold more water.
The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.

*/
public class Solution {
    public int maxArea(int[] height) {
        int max = 0 , left = 0, right = height.length-1;

        while (left < right) {
        	max = Math.max(max, (right-left) * Math.min(height[left], height[right]));

        	if (height[left] < height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        } 

        return max;
    }
}