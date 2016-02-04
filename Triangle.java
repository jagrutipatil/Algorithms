public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle.size() == 0)
    		return 0;

    	int[] target = new int[triangle.size()];
    	
    	for (int i = 0; i < triangle.size(); i++) {
    	    target[i] =  triangle.get(triangle.size()-1).get(i);
    	}

    	for (int i = triangle.size() -2 ; i >=0 ; i--) {
    		for (int j = 0; j < triangle.get(i).size(); j++) {
    			target[j] = triangle.get(i).get(j) + Math.min(target[j], target[j+1]);
    		}
    	}
    	return target[0];
    }
}