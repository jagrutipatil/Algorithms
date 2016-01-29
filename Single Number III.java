public class Solution {
    public int[] singleNumber(int[] nums) {
 		int diff = 0, i = 0;
 		int[] result = new int[2];

 		for (i = 0; i < nums.length; i++) {
 			diff = diff ^ nums[i];
 		}       

 		diff = (diff & (diff-1)) ^ diff;

 		for (i = 0; i < nums.length; i++) {
 			if ((nums[i] & diff) == 0)
 				result[0] = result[0] ^ nums[i];
 			else 
 			   result[1] = result[1] ^ nums[i];	
 		}
 		return result;
    }
}