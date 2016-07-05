/**
*Partition Array
*
*Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
*
*All elements < k are moved to the left
*All elements >= k are moved to the right
*Return the partitioning index, i.e the first index i nums[i] >= k.
* Logic: take two pointers, left < target and right >= target, go on swapping numbers until left < right
*/
public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
    	int i = 0, n = nums.length, j = n -1;

    	while (i < j) {
    		while (i < n && nums[i] < k) {
    			i++;
    		}

    		while (j >= 0 && nums[j] >= k) {
    			j--;
    		}

    		if (i < n && j >=0 && i < j) {
    			int t = nums[i];
    			nums[i] = nums[j];
    			nums[j] = t;
    		}
    	}
    	
    	return i;
    }
}