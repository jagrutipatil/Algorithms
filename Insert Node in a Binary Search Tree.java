/*
Insert Node in a Binary Search Tree

Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
    	if (root == null)
    		return node;

    	TreeNode temp = root;	
    	while (temp != null) {
    		if (temp.right == null && temp.val < node.val) {
    			temp.right = node;
    			break;
    		} else if (temp.left == null && temp.val >= node.val) {
    			temp.left = node;
    			break;
    		} else if (temp.left != null && temp.val >= node.val) {
    			temp = temp.left;
    		} else {
    			temp = temp.right;
    		}
    	}
 		return root;
    }
}