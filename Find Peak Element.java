public class Solution {
    public int findPeakElement(int[] nums) {
 		int curr = 0 , prev = 0, next = 0, max = 0, index = 0;
        
        if (nums.length > 0)
            max = nums[0];
            
 		for (int i = 1; i <= nums.length-2; i++) {
 			curr = nums[i];
 			prev = nums[i-1];
 			next = nums[i+1];
 			
 			if (curr > prev && curr > next && curr > max) {
 			    index = i;
 			    max = curr;
 			}
 		}   
 		
 		if (nums[nums.length-1] > max) {
 		    index = nums.length -1;
 		}

 		return index;    
    }
}