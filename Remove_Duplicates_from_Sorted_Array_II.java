public class Solution {
    public int removeDuplicates(int[] nums) {
    	int len = 0;
 		for (int i = 0; i < nums.length;i++) {
 			if (len == 0 || len == 1 || nums[i] != nums[len-1] || nums[i] != nums[len-2]) {
 				nums[len++] = nums[i];
 			}
 		}   
 		return len;    
    }
}