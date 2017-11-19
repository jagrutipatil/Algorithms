/*

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

*/

class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
    	return findSum(nums, 0, S, 0, map);    	
    }

    public int findSum(int[] nums, int start, int S, int currentSum, Map<String, Integer> map) {
    	if (map.containsKey(start + "->" + currentSum)) {
            return map.get(start + "->" + currentSum);
        }
        if (start == nums.length) {
    		if (currentSum == S) {
    			return 1;
    		}
    		return 0;
    	}
        int no = nums[start];
        int positive = findSum(nums, start+1, S, currentSum + no, map);
        int negative = findSum(nums, start+1, S, currentSum - no, map);
        map.put(start + "->" + currentSum, positive + negative);
        return positive + negative;
    }
}
