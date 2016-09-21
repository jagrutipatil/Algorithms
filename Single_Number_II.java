/*
	Single Number II
	
	Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

	Example
			Given [1,1,2,3,3,3,2,2,4,1] return 4

	Logic: take three variables: ones, twos, threes
		   ones: number appering only once (used xor to keep track of numbers appearing once)
		   twos: number appearing twice (used and to keep track of numbers appearing twice)
		   threes: number appearing thrice (and of onces and twice)

		   also remove the numbers from ones and twice those appeard thrice using & operator

*/

public class Solution {
    public int singleNumber(int[] nums) {
 		int ones = 0, twos = 0, threes = 0;

 		for (int i = 0; i < nums.length; i++) {
 			twos|= ones & nums[i];
 			ones ^= nums[i];
 			threes = ones & twos;
 			ones = ones & ~threes;
 			twos = twos & ~threes;
 		}       
 		return ones;
    }
}