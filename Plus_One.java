public class Solution {
    public int[] plusOne(int[] digits) {
    	boolean flag = true;
 		for (int j = digits.length-1; j>=0; j--) {
 			if (flag) {
 				if (digits[j] == 9) {
 					digits[j] = 0;
 				} else {
 					digits[j] = digits[j] + 1;
 					flag = false;
 				}

 				if (j == 0 && digits[j] == 0) {
 					int[] arr = new int[digits.length+1];
 					arr[0] = 1;
 					for (int k = 0; k< digits.length; k++) {
 						arr[k+1] = digits[k];
 					}
 					digits = arr;
 				}
 			}
 		}
 		
 		return digits;
    }
}