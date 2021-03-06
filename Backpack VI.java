/*
	Backpack VI

	Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

	Example
Given nums = [1, 2, 4], target = 4

The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
return 6

	Note: You just have to calculate number of ways not actual permuatations
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		if (nums[j] <= i) {
        			dp[i] += dp[i-nums[j]];
        		}
        	}
        }
        
        return dp[target];
    }
}