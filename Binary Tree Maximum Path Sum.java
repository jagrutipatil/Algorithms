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
	int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
 		 traverseDown(root);
 		 return maxSum;
    }

    public int traverseDown(TreeNode node) {    	
    	if (node == null)
    		return 0;

    	int left = Math.max(0, traverseDown(node.left));
    	int right = Math.max(0, traverseDown(node.right));
    	maxSum = Math.max(maxSum, left+right+node.val);
    	return Math.max(left, right) + node.val;
    }
}