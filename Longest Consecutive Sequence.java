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