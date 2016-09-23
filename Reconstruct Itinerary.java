/*
	Reconstruct Itinerary 

	Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

*/
//Not Working
//Failed test case [[JFK, KUL], [JFK, NRT], [NRT, JFK]], expected [JFK, NRT, JFK, KUL], returning [JFK, KUL]
//logic missing add the early terminating lexicographical orders at the end of result list

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

//________________________________________________________________________

// Without Priority Queue

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
 		Map<String, List<String>> map = new HashMap<String, List<String>>();       
 		List<String> result = new ArrayList<String>();

 		if (tickets.length == 0)
 			return result;
 			
 		for (String[] ticket : tickets) {
 			if (map.containsKey(ticket[0])) {
 				List<String> list = map.get(ticket[0]);
 				list.add(ticket[1]);
 				Collections.sort(list);
 			} else {
 				List<String> dest = new ArrayList<String>();
 				dest.add(ticket[1]);
 				map.put(ticket[0], dest);
 			}
 		}
        
        Stack<String> stack = new Stack<String>();
 		String start = "JFK";
 		stack.push(start);
        
        while (stack.size() > 0) {
             	while (map.containsKey(stack.peek()) && map.get(stack.peek()).size() > 0) {
 			        List<String> dest = map.get(stack.peek());
 			        String end = dest.get(0);
 			        dest.remove(0);
 			        map.put(stack.peek(), dest);
 			        stack.push(end);
 		        }               
 		    result.add(0, stack.pop());
        }


 		return result;
    }
}