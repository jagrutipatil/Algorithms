/*
	Super Ugly Number
	
	Write a program to find the nth super ugly number.

	Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
*/
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
 		int[] result = new int[n];
 		int[] index = new int[primes.length];
 		int[] duplicate = new int[primes.length];

 		result[0] = 1;

 		for (int i = 1; i < n; i++) {
 			result[i] = Integer.MAX_VALUE;

 			for (int j = 0; j < primes.length; j++) 
 				result[i] = Math.min(result[i], primes[j]*result[index[j]]);
 			
 			for (int j = 0; j < primes.length; j++) {
 				if (result[i] == primes[j]*result[index[j]]) {
 					index[j]++;
 				}
 			} 		
 		}    

 		return result[n-1];   
    }
}