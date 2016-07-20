/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Logic: use -1 for indicating tree is not balanced. once you find smallest subtree is non-balanced, use -1 for non-balanced tree.
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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        int height = findHeight(root);

        return height != -1;
    }

    int findHeight(TreeNode node) {
    	if (node == null)
    		return 0;

    	if (node.left == null && node.right == null)	
    		return 1;

    	int leftHeight = findHeight(node.left);
    	int rightHeight = findHeight(node.right); 
    	if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1)
    		return -1;
    	return Math.max(1 + leftHeight, 1 + rightHeight);	
    }
}