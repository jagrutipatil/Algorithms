/*
* Maximum SubArray
* Given an array of integers, find a contiguous subarray which has the largest sum.
*
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
        	return 0;

        int maxSum = Integer.MIN_VALUE;
        int cSum = 0;

        for (int i = 0; i < nums.length; i++) {
        	if (cSum + nums[i] < nums[i]) {
        		cSum = nums[i];
        	} else {
        		cSum+= nums[i];
        	}

        	if (cSum > maxSum) {
        		maxSum = cSum;
        	}
        }
        return maxSum;
    }
}

____________________________________________________
//Alternate question, asking for start and end index
/*
    Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

    Example:
            Give [-3, 1, 3, -3, 4], return [1,4].
            
*/
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        int sum = 0, max = Integer.MIN_VALUE, head = 0, tail = 0, cStart = 0, cLen = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (sum + A[i] < A[i]) {
                sum = A[i];
                cStart = i;
            } else {
                sum = sum + A[i];
            }

            if (max < sum) {
                max = sum;
                head = cStart;
                tail = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(head);
        result.add(tail);
        return result;
    }
}