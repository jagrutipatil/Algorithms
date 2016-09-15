/*
	Sliding Window Maximum

	Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

	For example,
		Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

	Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
 		LinkedList<Integer> deque = new LinkedList<Integer>();
 		if (nums.length == 0)
 		    return nums;
 		    
 		int[] result = new int[nums.length-k+1];

 		for (int i = 0; i < nums.length; i++) {
 			if (!deque.isEmpty() && deque.peekFirst() == i-k)
 				deque.poll();

 			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
 				deque.removeLast();
 			}
 			
 			deque.offer(i);
 			if (i >= k-1)
 				result[i-k+1] = nums[deque.peekFirst()];
 		}

 		return result;
    }
}