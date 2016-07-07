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