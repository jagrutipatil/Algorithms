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