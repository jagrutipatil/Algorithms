/*
Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Logic:
When the array has only positive elements then the product of all elements will be answer. 
Problem becomes interesting and complex simultaneously when there are negative elements.

You have three choices to make at any position in array.
1. You can get maximum product by multiplying the current element with 
    maximum product calculated so far.  (might work when current 
    element is positive).
2. You can get maximum product by multiplying the current element with 
    minimum product calculated so far. (might work when current 
    element is negative).
3.  Current element might be a starting position for maximum product sub
     array
*/


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


//_______________________________


public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
            
        int prevMax = nums[0], currMax = nums[0], prevMin = nums[0], currMin = nums[0], max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	currMax = Math.max(nums[i], Math.max(prevMax*nums[i], prevMin*nums[i]));
        	currMin = Math.min(nums[i], Math.min(prevMax*nums[i], prevMin*nums[i]));
        	max = Math.max(max, currMax);
        	prevMax = currMax;
        	prevMin = currMin;
        }
        return max;
    }
}