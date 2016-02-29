//Not Working

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
 		int m = tickets.length;
 		List<String> result = new ArrayList<String>();
 		Map<String, List<String>> map = new HashMap<String, List<String>>();

 		if (m == 0)
 			return result;

 		for (int i = 0; i < m; i++) {
 			if (map.containsKey(tickets[i][0])) {
 				List<String> list = map.get(tickets[i][0]);
 				list.add(tickets[i][1]);
 			} else {
 				List<String> list = new ArrayList<String>();
 				list.add(tickets[i][1]);
 				map.put(tickets[i][0], list);
 			} 			
 		}    

 		String start = "JFK";
 		String next = "";

 		while(!start.equals("") && map.containsKey(start)) {
 				List<String> list = map.get(start); 				
 				Collections.sort(list); 			
 				result.add(start);	 				

 				next = list.get(0);
 				list.remove(0);
 				map.put(start, list); 				
 				start = next;
 		}   
 		result.add(start);

 		return result;
    }
}


//Working using Priority Queue

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
 		Map<String, PriorityQueue<String>> map = new HashMap<>();       
 		List<String> result = new LinkedList<String>();
 		Stack<String> stack = new Stack<String>();

 		for (String[] ticket:tickets) {
 			map.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
 		}
 		stack.push("JFK");

 		while (stack.size() != 0) {
 			while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
 				stack.push(map.get(stack.peek()).poll());
 			}
 			result.add(0, stack.pop());
 		}	
 		return result;
    }
}