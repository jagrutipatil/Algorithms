/*
	Power of Four

	Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

	Example:
		Given num = 16, return true. Given num = 5, return false.

	Logic: In power of 4 bitwise representation number of zeros are always even
			e.g: 16 = 10000 true
				 8 =  1000 false
				 4 = 100 true
*/

public class Solution {
    public boolean isPowerOfFour(int num) {
 		int count1 = 0, count0 = 0;
 		while (num > 0) {
 			if ((num&1) == 1) {
 			    count1++;
 			} else {
 			    count0++;
 			} 	
 			num=num>>1;
 		}
 		return count1 == 1 && (count0%2== 0);
    }
}