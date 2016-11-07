/*
	Delete Node in a BST

	Delete a node in a BST.

	Basically, the deletion can be divided into two stages:

	1. Search for a node to remove.
	2. If the node is found, delete the node.


	Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7


*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
 		       return deleteNode(root, null, key);
    }

    private TreeNode deleteNode(TreeNode node, TreeNode parent, int key) {
    	if (node == null) {
    		return null;
    	}

    	if (node.val > key) {
    		deleteNode(node.left, node, key);
    	} else if (node.val < key) {
    		deleteNode(node.right, node, key);
    	} else if (node.val == key) {
    		    TreeNode left = node.left;
    			TreeNode right = node.right;

    			if (parent == null) {
    				if (left != null) {
    					TreeNode newRoot = left;

    					while (newRoot.right != null) {
    						newRoot = newRoot.right;
    					}
    					newRoot.right = right;

    					return left;
    				} else {
    					return right;
    				}
    			} else {

    				if (left != null) {
    					if (parent.left == node) {
    						parent.left = left;
    					}

    					if (parent.right == node) {
    						parent.right = left;
    					}

    					while (left.right != null) {
    						left = left.right;
    					}
    					left.right = right;

    				} else {
    					    if (parent.left == node) {
    							parent.left = right;
    						}

    						if (parent.right == node) {
    							parent.right = right;
    						}
    				}  				
    			}
    			return parent;
    	}
    	return node;
    }
}