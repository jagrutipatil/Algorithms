public class Solution {
    public List<Integer> grayCode(int n) {
    	List<Integer> result = new ArrayList<Integer>();
    	
        result.add(0);
    	for (int i = 0; i < n; i++) {
    		int inc = 1 << i;
    		for (int j = result.size()-1; j >= 0; j--) {
    			result.add(result.get(j) + inc);
    		}
    	}
    	return result;
    }
}