/*
	Contains Duplicate II

	Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

	Logic: Use hashmap(array value, index) to search previously occured same value, if occured but diff is not less than k then still update the index in map bcz we have to find diff at most k.
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
 		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

 		for (int i = 0; i < nums.length; i++) {
 			if (map.containsKey(nums[i])) {
 				if (Math.abs(i - map.get(nums[i])) <= k) {
 					return true;
 				}  				
 			} 
 			map.put(nums[i], i);
 		}
 		return false;
    }
}