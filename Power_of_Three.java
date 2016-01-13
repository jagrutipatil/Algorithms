/*
Ternary number that is power of 3 will be something like 10,100,1000, etc, analogous to binary numbers that are powers of 2.
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
 		return Integer.toString(n, 3).matches("10*");       
    }
}