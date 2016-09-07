/*
	Sum of Two Integers

	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

	Example:
			Given a = 1 and b = 2, return 3.

	Logic: Use XOR for partial addition, & and left shift for carry. 			
*/

public class Solution {
    public int getSum(int no1, int no2) {
        int a = no1 ^ no2;
        int c = (no1 & no2) << 1;
        
        while (c != 0) {
            int p = a ^ c;
            c = (a & c) << 1;
            a = p;
        }
        return a;
    }
}