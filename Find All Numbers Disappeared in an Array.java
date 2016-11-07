/*
	Find All Numbers Disappeared in an Array

	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

	Find all the elements of [1, n] inclusive that do not appear in this array.

	Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

	Example:

	Input:
		[4,3,2,7,8,2,3,1]

	Output:
		[5,6]

	Logic: 
1.The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].In this way all the numbers that we have seen will be marked as negative. 

2.	In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
*/

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
 		List<Integer> result = new ArrayList<Integer>();

 		for (int no : nums) {
 			int index = Math.abs(no)-1;
 			if (nums[index] > 0) {
 				nums[index] = -nums[index];
 			}
 		}

 		for (int i = 0; i < nums.length; i++) {
 			if (nums[i] > 0) {
 				result.add(i+1);
 			}
 		}
 		
 		return result;
    }
}