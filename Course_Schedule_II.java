public class Solution {
	private int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
 		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

 		for (int[] edge : prerequisites) {
 			if (map.containsKey(edge[0])) {
 				map.get(edge[0]).add(edge[1]);
 			} else {
 				List<Integer> list = new ArrayList<Integer>();
 				list.add(edge[1]);
 				map.put(edge[0], list);
 			}
 		}

 		int[] visit = new int[numCourses];
 		int[] result = new int[numCourses];

 		for (int i = 0; i < numCourses; i++) {
 			if (!isCycle(map, visit, result, i)) {
 				return new int[0];
 			}
 		}
 		
 		return result;
    }


    boolean isCycle(Map<Integer, List<Integer>> map, int[] visit, int[] result, int no) {
    	if (visit[no] == -1)
    		return false;
    	
    	if (visit[no] == 1)
    		return true;

    	visit[no] = -1;
    	if (map.containsKey(no)) {
    		for (int i : map.get(no)) {
    			if (!isCycle(map, visit, result, i)) {
    				return false;
    			}
    		}
    	}	

    	visit[no] = 1;
    	result[count] = no;
    	count++;
    	return true; 
    }
}
