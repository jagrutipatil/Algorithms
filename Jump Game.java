/*
Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Logic:

We can track the maximum index that can be reached. The key to solve this problem is to find: 1) when the current position can not reach next position (return false) , and 2) when the maximum index can reach the end (return true).

The largest index that can be reached is: i + A[i].
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
    	int max = 0;
    	
    	for (int i = 0; i < A.length-1; i++) {
    		if (max <= i && A[i] == 0) {
    			return false;
    		}

    		if (i + A[i] > max) {
    			max = i + A[i];
    		}

    		if (max >= A.length-1) {
    			return true;
    		}
    	}
    	return true;
    }
}
