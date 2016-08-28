/*
Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

Logic: append node's value and next sign to string until you reach leaf node.

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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
 		List<String> result = new ArrayList<String>();
 		if (root != null)
 			buildPaths(root, "", result);
 		return result;
    }

    private void buildPaths(TreeNode node, String str, List<String> result) {
    	str += node.val;

    	if (node.left == null && node.right == null) {
    		result.add(str);
    	}

    	if (node.left != null)
    		buildPaths(node.left, str + "->", result);

    	if (node.right != null)
    		buildPaths(node.right, str + "->", result);    		
    }
}