/*
3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
 		int i = 0, j = 0, k = 0, n = numbers.length;   	
 		int sum = 0, minDiff = Integer.MAX_VALUE, minSum = Integer.MAX_VALUE;

 		Arrays.sort(numbers);
 		for (i = 0; i < n; i++) {
 			j = i+1;
 			k = n - 1;
 			while (j < k) {
				sum = numbers[i] + numbers[j] + numbers[k];

 				if (sum <= target) {
 					j++;
 				} else if (sum > target) {
 					k--;
 				}

 				if (Math.abs(sum - target) < minDiff) {
 					minDiff = Math.abs(sum - target);
 					minSum = sum;
 				} 			
 			}
 		}

 		return minSum;
    }
}
