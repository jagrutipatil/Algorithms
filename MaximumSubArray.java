/*
* Maximum SubArray
* Given an array of integers, find a contiguous subarray which has the largest sum.
*
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
        	return 0;

        int maxSum = Integer.MIN_VALUE;
        int cSum = 0;

        for (int i = 0; i < nums.length; i++) {
        	if (cSum + nums[i] < nums[i]) {
        		cSum = nums[i];
        	} else {
        		cSum+= nums[i];
        	}

        	if (cSum > maxSum) {
        		maxSum = cSum;
        	}
        }
        return maxSum;
    }
}