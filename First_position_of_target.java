/**
*	First Position of Target
*	For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
*
*	If the target number does not exist in the array, return -1.
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;

        while (start <= end) {
        	mid = (start + end)/2;

        	if (nums[mid] == target) {
        		if (mid-1 >= 0 && nums[mid-1] == target) {
        			end = mid;
        			continue;
        		}
        		return mid;
        	} else if (nums[mid] < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return -1;
    }
}