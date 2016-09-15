/*
House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
	Example
		Given [3, 8, 4], return 8

Logic:
	The key is to find the relation dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]).
	
*/

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] nums) {
    if(nums==null||nums.length==0)
        return 0;
 
    if(nums.length==1)
        return nums[0];
 
    long[] dp = new long[nums.length];
    dp[0]=nums[0];
    dp[1]=Math.max(nums[0], nums[1]);
 
    for(int i=2; i<nums.length; i++){
        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
    }
 
    return dp[nums.length-1];
    }
}


//____________________________________________________________
//Without extra memory

public class Solution {
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(nums[i]+prev, curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}