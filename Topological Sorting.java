/*
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.

Logic: find a node which has no incoming edge, this will be our start node. Delete the incoming edge count for its neighbors and the neighbor which has zero incoming edge can be next root node, add this node to queue and
		repeat the process for each root node in queue until queue is empty. 
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    	ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

    	for (DirectedGraphNode node: graph) {
    		for (DirectedGraphNode neighbor : node.neighbors) {
    			int label = neighbor.label;
    			if (map.containsKey(label)) {
    				map.put(label, map.get(label) + 1);
    			} else {
    				map.put(label, 1);
    			}
    		}
    	}

    	for (DirectedGraphNode node : graph) {
    		if (!map.containsKey(node.label)) {
    			queue.add(node);
    			result.add(node);
    		}
    	}

    	while (queue.size() > 0) {
    		DirectedGraphNode node = queue.remove();

    		for (DirectedGraphNode neighbor: node.neighbors) {
    			int label = neighbor.label;
    			map.put(label, map.get(label)-1);
    			if (map.get(label) == 0) {
    				queue.add(neighbor);
    				result.add(neighbor);
    			}
    		}
    	}
    	return result;
    }
}