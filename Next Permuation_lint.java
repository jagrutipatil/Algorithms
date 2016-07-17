/*
Next Permutation

Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

For [1,3,2,3], the next permutation is [1,3,3,2]

For [4,3,2,1], the next permutation is [1,2,3,4]

*/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        int desc = 0, i = 0;

        for (i = nums.length-1; i > 0; i--) {
        	if (nums[i] > nums[i-1]) {
        		desc = i;
        		break;
        	}
        }

        if (desc == 0) {
        	Arrays.sort(nums);
        	return nums;
        }

        for (i = nums.length - 1; i >= desc; i--) {
        	if (nums[i] > nums[desc -1]) {
        		swap(nums, i, desc-1);
        		break;
        	}
        }

        reverse(nums, desc, nums.length-1);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
    	for (; i < j; i++, j--) {
    		swap(nums, i, j);
    	}
    }
}