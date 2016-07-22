/*
Remove Node in Binary Search Tree

Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.

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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
        	return null;
        }

        if (root.val > value) {
        	root.left = removeNode(root.left, value);
        } else if (root.val < value) {
        	root.right = removeNode(root.right, value);
        } else {
        	if (root.left == null)
        		return root.right;

        	if (root.right == null)
        		return root.left;

        	TreeNode temp = findSmallest(root, root.right);	

        	temp.left = root.left;
        	temp.right = root.right;
        	root = temp;
        }
        return root;
    }

    TreeNode findSmallest(TreeNode parent, TreeNode node) {
    	if (node.left == null) {
    		parent.right = node.right;
    		return node;
    	} else {
    		TreeNode father = node;
    		TreeNode temp = node.left;

    		while (temp.left != null) {
    			father = temp;
    			temp = temp.left;
    		}
    		father.left = temp.right;
    		return temp;
    	}
    }
}