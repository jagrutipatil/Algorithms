public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		combination(result, new ArrayList<Integer>(), k, 1, n);       
 		return result;
    }

    void combination(List<List<Integer>> result, List<Integer> temp, int k, int start, int n) {
    	if (temp.size() == k && n == 0) {
    		List<Integer> list = new ArrayList<Integer>(temp);
    		result.add(list);
    		return;
    	}

    	for (int i = start; i <= 9; i++) {
    		temp.add(i);
    		combination(result, temp, k, i+1, n-i);
    		temp.remove(temp.size()-1);
    	}
    }
}