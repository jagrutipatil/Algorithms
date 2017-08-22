/*
	Sum of Two Integers

	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

	Example:
			Given a = 1 and b = 2, return 3.

	Logic: Use XOR for partial addition, & and left shift for carry. 			
*/

class Solution {
    public int getSum(int a, int b) {
 		int result = a ^ b;
 		int carry = (a & b) << 1;

 		while (carry != 0) {
 			a = result;
 			b = carry;
 			result = a ^ b;
 			carry = (a & b) << 1;
 		}

 		return result;
    }
}
