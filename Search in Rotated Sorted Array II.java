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