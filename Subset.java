public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		Arrays.sort(nums);       

 		for (int i: nums) {
 			List<List<Integer>> temp = new ArrayList<List<Integer>>();

 			for (List<Integer> list: result) {
 				temp.add(new ArrayList<Integer>(list));
 			}

 			for (List<Integer> list: temp) {
 				list.add(i);
 			}

 			List<Integer> self = new ArrayList<Integer>();
 			self.add(i);
 			temp.add(self);

 			result.addAll(temp);
 		}

 		List<Integer> empty = new ArrayList<Integer>();
 		result.add(empty);

 		return result;
    }
}