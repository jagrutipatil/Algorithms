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