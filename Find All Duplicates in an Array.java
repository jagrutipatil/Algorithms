/*
	Find All Duplicates in an Array

	Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

	Find all the elements that appear twice in this array.

	Could you do it without extra space and in O(n) runtime?

	Example:
	Input:
		[4,3,2,7,8,2,3,1]

	Output:
		[2,3]

	Logic:
		1. Negate the numbers already appeard in array.

*/


public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
 		List<Integer> result = new ArrayList<Integer>();
 		for (int no : nums) {
 		    int index = Math.abs(no);
 			if (nums[index-1] < 0) {
 				result.add(index);
 			} else {
 				nums[index-1] = -nums[index-1];
 			}
 		}       

 		for (int i = 0; i < nums.length; i++) {
 				nums[i] = Math.abs(nums[i]);
 		}       

 		return result;
    }
}