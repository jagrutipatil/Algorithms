/** 
*  Given an array of integers, find the subarray with smallest sum.
*  Return the sum of the subarray.
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
	    int minSum = Integer.MAX_VALUE;
	    int cSum = 0;

	    if (nums.size() == 0) {
	    	return 0;
	    }

	    for (int i = 0; i < nums.size(); i++) {
	    	int cno = nums.get(i);
	    	if (cSum + cno > cno) {
	    		cSum = cno;
	    	} else {
	    		cSum+= cno;
	    	}

	    	if (cSum < minSum) {
	    		minSum = cSum;
	    	}
	    }

	    return minSum;
    }
}
