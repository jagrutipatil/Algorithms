public class Solution {
    public int maxProduct(int[] nums) {
 		if (nums.length == 0)
 			return 0;
 		int currMax  = nums[0];
 		int currMin  = nums[0];
 		int maxSoFar = nums[0];

 		for (int i = 1; i < nums.length; i++) {
 			int temp = currMax;
 			currMax = Math.max(Math.max(nums[i], currMax*nums[i]), nums[i]*currMin);
 			currMin = Math.min(Math.min(nums[i], temp*nums[i]), currMin*nums[i]);
 			maxSoFar = Math.max(maxSoFar, currMax);
 		}    
 		return maxSoFar;  
    }
}