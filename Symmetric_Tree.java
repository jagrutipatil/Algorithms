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

    public boolean isSymmetric(TreeNode root) {
 		if (root == null)     
 			return true;

 		return checkSymmetricNodes(root.left, root.right);
    }

    boolean checkSymmetricNodes(TreeNode n1, TreeNode n2) {
    	if (n1 == null && n2 == null) {
    		return true;
    	} 

    	if (n1 == null || n2 == null) {
    		return false;
    	} 

    	return n1.val == n2.val && checkSymmetricNodes(n1.left, n2.right) && checkSymmetricNodes(n1.right, n2.left);
    }
}