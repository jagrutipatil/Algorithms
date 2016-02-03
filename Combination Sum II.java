public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
 		combination(candidates, result, new ArrayList<Integer>(), target, 0);
 		Set<List<Integer>> set = new HashSet<List<Integer>>(result);
 		result.clear();
 		result.addAll(set);
 		return result;
    }

    void combination(int[] candidates, List<List<Integer>> result, List<Integer> temp, int target, int start) {
    	if (target == 0) {
    		List<Integer> list = new ArrayList<Integer>(temp);
    		result.add(list);
    		return;
    	}

    	for (int i = start; i < candidates.length; i++) {
    	    if (candidates[i] > target) {
    	       return;
    	    }
    		temp.add(candidates[i]);
    		combination(candidates, result, temp, target - candidates[i], i+1);
    		temp.remove(temp.size()-1);
    	}
    }
}