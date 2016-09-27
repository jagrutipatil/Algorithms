/*
    Search in Rotated Sorted Array II

    Follow up for "Search in Rotated Sorted Array":
    
    What if duplicates are allowed? 

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.
    
    logic: Dupliates will only cause problem if its at both ends, so we can avoid the duplicates by compairing start and mid
*/
public class Solution {
    public boolean search(int[] nums, int target) {
 		return binarySearch(nums, target, 0, nums.length-1);       
    }

    boolean binarySearch(int[] nums, int target, int l, int r) {
    	if (r < l) 
    		return false;

    	int mid = (l + r)/2;
    	if (target == nums[mid])
    		return true;

    	if (nums[l] < nums[mid]) {
    		if (nums[mid] > target && target >= nums[l]) {
    			return binarySearch(nums, target, l, mid-1);
    		} else {
    			return binarySearch(nums, target, mid+1, r);
    		}
    	} else if (nums[l] > nums[mid]) {
    		if (nums[mid] < target && nums[r] >= target) {
    			return binarySearch(nums, target, mid+1, r);
    		} else {
    			return binarySearch(nums, target, l, mid-1);
    		}
    	} else {
    		return binarySearch(nums, target, l+1, r);
    	}
    }
}