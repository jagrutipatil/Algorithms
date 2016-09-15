/*
	Valid Perfect Square

	Given a positive integer num, write a function which returns True if num is a perfect square else False.

	Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

Logic: 1. Perfect square is a number whose roots are integers, perfect square and square are same
	   2. Use binary search to find out sqaure root, use long for avoiding overflow of max values	
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
		long start = 1, end = num;
        if (num < 1)
            return false;
            
		while (start < end) {
			long mid = start + (end-start)/2;
			long no = mid*mid;
			
			if (no == num) {
				return true;
			} else if (no > num) {
				end = mid-1;
			} else {
				start = mid+1;
			}			
		}        
		return start*start == num;
    }
}