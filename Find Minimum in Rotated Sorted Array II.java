/*
	Find Minimum in Rotated Sorted Array II

	Follow up for "Find Minimum in Rotated Sorted Array":
	What if duplicates are allowed?

	Would this affect the run-time complexity? How and why?
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	Find the minimum element.

	Logic: 
		1. use binary search to find minimum element
		2. if only one element in an array return that element
		3. if two elements then return the minimum
		4. compare start element and mid element, 
			4.1. if start is less than mid and also end that means start is smallest
			4.2. if start is is greater than mid 
*/

public class Solution {
    public int findMin(int[] nums) {
 		int start = 0, end = nums.length-1;

 		while (start <= end) {
 			int mid = start + (end-start)/2;

 			if (start == end) {
 				return nums[start];
 			} else if (end - start == 1) {
 				return Math.min(nums[start], nums[end]);
 			}
 			
 			if (nums[start] < nums[mid]) {
 				if (nums[start] < nums[end]) {
 					return nums[start];
 				} else {
 					start = mid+1;
 				}
 			} else if (nums[start] > nums[mid]) {
 				if (nums[mid] <= nums[end]) {
 					end = mid;
 				} else {
 					start = mid+1;
 				}
 			} else {
 				start+= 1;
 			}
 		}
 		return -1;       
    }
}