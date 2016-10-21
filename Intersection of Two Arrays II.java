/*
	Intersection of Two Arrays II   
	
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
 		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
 		List<Integer> list = new ArrayList<Integer>();

 		if (nums2.length > nums1.length) {
 			putIntoMap(map, nums1);
 			intersection(map, nums2, list);
 		} else {
 			putIntoMap(map, nums2);
 			intersection(map, nums1, list);
 		}

 		int[] result = new int[list.size()];
 		for (int i = 0; i < list.size(); i++) {
 			result[i] = list.get(i);
 		}
 		return result;
    }

    private void intersection(Map<Integer, Integer> map, int[] nums2, List<Integer> list) {
 			for (int no : nums2) {
 				if (map.containsKey(no)) {
 					list.add(no);
 					if (map.get(no) == 1) {
 						map.remove(no);
 					} else {
 						map.put(no, map.get(no)-1);
 					}
 				}
 			}    
    }

    private void putIntoMap(Map<Integer, Integer> map, int[] nums1) {
     	for (int no : nums1) {
 			if (map.containsKey(no)) {
 				map.put(no, map.get(no) + 1);
 			} else {
 				map.put(no, 1);
 			}
 		}
    }
}