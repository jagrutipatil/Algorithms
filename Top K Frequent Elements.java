/*
	Top K Frequent Elements
	
	Given a non-empty array of integers, return the k most frequent elements.

	For example,
	Given [1,1,1,2,2,3] and k = 2, return [1,2].

	Note: 
		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
		k equal to result size

	Logic:
		1. put no vs its frequency in hashmap
		2. take array initalize it with list of integers, add frequecy vs list of numbers in the array, frequency == index of array
		3. traverse back from array until size of result becomes k
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
 		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
 		List<List<Integer>> list = new ArrayList<List<Integer>>();

 		int max = 0;
 		for (int no : nums) {
 			if (map.containsKey(no)) {
 				map.put(no, map.get(no)+1);
 			} else {
 				map.put(no, 1);
 			}
 			if (map.get(no) > max) {
 				max = map.get(no);
 			}
 		}

 		for (int i = 1; i <= max+1; i++) {
 			list.add(new ArrayList<Integer>());
 		}

 		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
 			list.get(entry.getValue()).add(entry.getKey());
 		}

 		List<Integer> result = new ArrayList<Integer>();
 		for (int i = list.size()-1; i >= 0; i--) {
 			if (list.get(i).size() != 0) {
 				result.addAll(list.get(i));
 				if (result.size() == k) {
 					return result;
 				}
 			}
 		}
 		return result;
    }
}