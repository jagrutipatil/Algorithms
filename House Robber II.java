/*
    House Robber II

    After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

    Logic: Same as House Robber I, just here traverse through array twice, and take max of of array with start 0 to arr.length-2 and 1 to array.length-1.
*/

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums.length < 2)
            return nums.length == 0? 0 : nums[0];

        return Math.max(houseRobber(nums, 0, nums.length-2), houseRobber(nums, 1, nums.length-1));
    }

    private int houseRobber(int[] nums, int l, int h) {
        int prev = 0, curr = 0;
        for (int i = l; i <= h; i++) {
            int temp = Math.max(nums[i] + prev, curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}