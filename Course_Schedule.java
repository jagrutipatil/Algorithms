public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {    	
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    	for (int[] edge: prerequisites) {
    		if (map.containsKey(edge[1])) {
    			map.get(edge[1]).add(edge[0]);
    		} else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(edge[0]);
    			map.put(edge[1], list);
    		}
    	}

    	int[] visit = new int[numCourses];
    	for (int i = 0; i < numCourses; i++) {
    		if (!isCycle(map, visit, i)) {
    			return false;
    		}
    	}
    	return true;
    }

    boolean isCycle(Map<Integer, List<Integer>> map, int[] visit, int no) {
    	if (visit[no] == -1) 
    		return false;
    	if (visit[no] == 1)
    		return true;

    	visit[no] = -1;

    	if (map.containsKey(no)) {
    		for (int i : map.get(no)) {
    			if (!isCycle(map, visit, i)) {
    				return false;
    			}
    		}
    	} 

    	visit[no] = 1;
    	return true;
    }
}