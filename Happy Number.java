/*
Happy Number

Write an algorithm to determine if a number is happy.

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Logic: Use Set to keep track of previously occured numbers until you find out if number is happy number or not, if number is happy number its sequence of next numbers won't be repeated.

*/
public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
    	Set<Integer> set = new HashSet<Integer>();

    	while (n != 1) {
    		if (set.contains(n))
    			return false;
    		set.add(n);	
    		n = getNextNumber(n);
    	}
    	return true;
    }

    private int getNextNumber(int no) {
    	int result = 0;

    	while (no != 0) {
    		result = result + (no%10)*(no%10);
    		no = no/10;
    	}
    	return result;
    }
}