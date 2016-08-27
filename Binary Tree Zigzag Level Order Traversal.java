/*
Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

Logic: 1. Do level order using queue
	   2. Use boolean flag operator to reverse order
	   3. when flag is false, add all nodes at the start of list, if its true add at the end of list.
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	boolean order = true;
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root != null)
    		queue.add(root);

    	while (queue.size() > 0) {
    		int size = queue.size();
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.remove();
    			if (order) {
    				list.add(node.val);
    			} else {
    				list.add(0, node.val);
    			}
    			if (node.left != null)
    				queue.add(node.left);
    			if (node.right != null)
    				queue.add(node.right);    				    			
    		}
    		order = order? false : true;
    		result.add(list);
    	}
    	return result;
    }
}