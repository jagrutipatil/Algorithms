/*
	Maximum Subarray II

	Given an array of integers, find two non-overlapping subarrays which have the largest sum.
	The number in each subarray should be contiguous.
	Return the largest sum.

	Example
	For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

	Logic: Same as Maximum subarray, just keep maximum sum till each index and have max of left max sum and right max sum.

*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
       int[] left = new int[nums.size()];
       int result = Integer.MIN_VALUE;
       int sum = 0;
       int max = Integer.MIN_VALUE;

       for (int i = 0; i < nums.size(); i++) {
       	   sum = Math.max(sum + nums.get(i), nums.get(i));
       	   max = Math.max(max, sum);
       	   left[i] = max;	
       }

       sum = 0;
       max = Integer.MIN_VALUE;
       for (int i = nums.size()-1; i > 0; i--) {
       		sum = Math.max(sum + nums.get(i), nums.get(i));
       		max = Math.max(max, sum);
       		result = Math.max(result, max + left[i-1]);
       }
       return result;
    }
}

