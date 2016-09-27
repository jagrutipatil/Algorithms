/*
    Find Minimum in Rotated Sorted Array

    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You may assume no duplicate exists in the array.
    
    Logic: Use binary search
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int start = 0, end = num.length - 1, mid = 0;

        while (start <= end) {
        	mid = (start + end)/2;
        	if (num[start] < num[end]) {
        		return num[start];
        	}

        	if (start == end) {
        		return num[start];
        	} else if (end - start == 1) {
        		return Math.min(num[start], num[end]);
        	}

        	if (num[mid] < num[end]) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        return -1;
    }
}

//_______________________
//another approach
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        if (nums[start] < nums[end])
            return nums[start];

        while (start < end) {
            int mid = start + (end-start)/2;
            if (nums[start] <= nums[mid]) {
                if (nums[start] < nums[end]) {
                    return nums[start];
                } else {
                    start = mid+1;
                }                   
            } else {
                if (nums[mid] <= nums[end]) {
                    end = mid;
                } else {
                    start = mid+1;
                }
            }
        }       

        return Math.min(nums[start], nums[end]);
    }
}