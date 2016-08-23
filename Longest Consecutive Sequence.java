/*
Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
 		Set<Integer> set = new HashSet<Integer>();

 		for (Integer no : nums) {
 			set.add(no);
 		}

 		int max = 0;
 		for (int no: nums) {
 			max = Math.max(max, maxCount(no, set));
 		}

 		return max;
    }

    int maxCount(int no, Set<Integer> set) {
    	int count = 1;
    	int k = no;

    	while (set.contains(--k)) {
    		set.remove(k);
    		count++;
    	}

    	k = no;

    	while (set.contains(++k)) {
    		set.remove(k);
    		count++;
    	}
    	return count;
    }

} 