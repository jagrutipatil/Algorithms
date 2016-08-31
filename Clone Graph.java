/*
Clone Graph:

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

 1
  / \
 /   \
0 --- 2
     / \
     \_/


Logic: Use map to keep track of original vs cloned node. 
	   Use Queue to sequentially clone all nodes     
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 		
        if (node == null) {
            return node;
        }
 		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
 		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
 		map.put(node, newHead);
 		queue.add(node);

 		while (queue.size() > 0) {
 			UndirectedGraphNode curr = queue.remove();

 			for (UndirectedGraphNode aNeigh : curr.neighbors) {
 				if (!map.containsKey(aNeigh)) {
 					UndirectedGraphNode copy = new UndirectedGraphNode(aNeigh.label);
 					map.put(aNeigh, copy);
 					map.get(curr).neighbors.add(copy);
 					queue.add(aNeigh);

 				} else {
 					map.get(curr).neighbors.add(map.get(aNeigh));
 				} 
 			}
 		}

 		return newHead;
    }
}

__________________________________________________________________________

//Cleaner Version with comments

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	
    	if (node == null)
    	    return null;
    	    
    	UndirectedGraphNode cloneHead = new UndirectedGraphNode(node.label);
    	queue.add(node);
    	map.put(node, cloneHead);

    	while (queue.size() > 0) {
    		UndirectedGraphNode curr = queue.remove();

    		for (UndirectedGraphNode neighbor : curr.neighbors) {
    			if (!map.containsKey(neighbor)) {   //IF NODE DOES NOT EXITS CLONE IT
    				UndirectedGraphNode neighClone = new UndirectedGraphNode(neighbor.label);    				    				
    				map.put(neighbor, neighClone);
    				queue.add(neighbor);
    			} //ADD THE NEIGHBOUR'S CLONE TO CLONED NODE OF CURRENT NODE.
    			map.get(curr).neighbors.add(map.get(neighbor));  
    		}
    	}
    	return map.get(node);
    }
}