/*

Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Logic: Return minimum integer value for null node to choose alternate subtree while getting maximum
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
       if (root == null)
          return 0;
        
        if (root.left == null && root.right == null)       
            return 1;
        
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));    
    }
}