public class Solution {
    public boolean increasingTriplet(int[] nums) {
 		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

 		for (int no : nums) {
 			if (min1 >= no) {
 				min1 = no;
 			} else if (min2 >= no) {
 				min2 = no;
 			} else {
 				return true;
 			}
 		}
 		return false;       
    }
}