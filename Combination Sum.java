public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		Arrays.sort(candidates);
 		combination(candidates, result, new ArrayList<Integer>(), target, 0, candidates.length-1);       
 		return result;
    }

    void combination(int[] candidates, List<List<Integer>> result, List<Integer> temp, int target, int start, int end) {
    	if (target == 0) {
    		List<Integer> list = new ArrayList<Integer>(temp);
    		result.add(list);
    		return;
    	}

    	for (int i = start; i <= end; i++) {
    	    if (target < candidates[i])
    	        return;
    	        
    		temp.add(candidates[i]);
    		combination(candidates, result, temp, target-candidates[i], i, end);
    		temp.remove(temp.size()-1);
    	}
    }
}