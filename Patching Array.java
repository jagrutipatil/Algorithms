public class Solution {
    public int minPatches(int[] nums, int n) {
 		long miss = 1;
 		int count = 0, i = 0;

 		while (miss <= n) {
 			if (i < nums.length && nums[i] <= miss) {
 				miss += nums[i++];
 			} else {
 				miss += miss;
 				count++;
 			}
 		}
 		return count;       
    }
}