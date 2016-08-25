/*
Data Stream Median

Numbers keep coming, return the median of numbers at every time a new number added.

Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
 		int[] median = new int[nums.length];
 		int i = 0, j = 0;
 		median[0] = nums[0];
 		for (i = 1; i < nums.length; i++) {
 		    int no = nums[i];
 			for (j = i-1; j>=0; j--) {
 				if (no > nums[j]) {
 					break;
 				}
 				nums[j+1] = nums[j];
 			}
 			nums[j+1] = no;
 			median[i] = nums[i/2];
 		}
 		return median;
    }
}