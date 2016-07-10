/*
  Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        int xor = 0;

        for (int a : A) {
        	xor ^= a;
        }
        return xor;
    }
}
