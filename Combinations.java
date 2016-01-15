public class Solution {
    public List<List<Integer>> combine(int n, int k) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		List<Integer> item = new ArrayList<Integer>();
 		dfs(n, k, 1, item, result);
 		return result;
    }

    public void dfs(int n, int k, int start, List<Integer> temp, List<List<Integer>> result) {
    	if (temp.size() == k) {
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}

    	for (int i = start; i <= n; i++) {
    		temp.add(i);
    		dfs(n, k, i+1, temp, result);
    		temp.remove(temp.size()-1);
    	}
    }
}