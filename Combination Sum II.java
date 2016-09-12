/*
    Combination Sum II

    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 

A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

*/

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


___________________________________________________________________________________________________________
//Without Set Solution

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<Integer>(), result);    
        return result;
    }


    private void combinationSum2(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i-1] == candidates[i])
                continue;
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i+1, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }
}