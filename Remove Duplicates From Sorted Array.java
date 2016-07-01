/**
*
*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
*Do not allocate extra space for another array, you must do this in place with constant memory.
*e.g:
*	Given input array A = [1,1,2],
*
*	Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
 		int i = 0 , j = 1;
 		
 		if (nums == null || nums.length == 0) {
 			return 0;
 		}

 		while (j < nums.length) {
 			while (j < nums.length && nums[i] == nums[j]) {
 				j++;
 			}
 			if (j < nums.length) {
 				i++;
 				nums[i] = nums[j];
 				j++;
 			} 			
 		}
 		return i+1;
    }
}