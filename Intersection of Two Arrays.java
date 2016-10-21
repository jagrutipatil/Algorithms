/*
	Intersection of Two Arrays

	Given two arrays, write a function to compute their intersection.

	Example:
	
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
 		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
 		
 		for (int no : nums1) {
 			if (map.containsKey(no)) {
 				map.put(no, map.get(no)+1);
 			} else {
 				map.put(no, 1);
 			}
 		}

 		Set<Integer> set = new HashSet<Integer>();
 		for (int no : nums2) {
 			if (map.containsKey(no)) {
 				set.add(no);
 			}
 		}

 		int[] result = new int[set.size()];
 		Iterator<Integer> it = set.iterator();
 		int i = 0;
 		while (it.hasNext()) {
 			result[i] = it.next();
 			i++;
 		}
 		
 		return result;
    }
}