/*
Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The minimum depth is 2.

Logic: return Integer.MAX_VALUE for null node in helper function.
        e.g: 1
              \
              2
        Here Height should be 2. so return Integer.MAX_VALUE, so in minimum operation (Integer.MAX_VALUE, 1) would return 1.
*/

/* Minimum Depth of Binary Tree */
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
    public int minDepth(TreeNode root) {
 		if (root == null) {
 			return 0;
 		}       

        int min1 = minDepth(root.left)+1;
        int min2 = minDepth(root.right)+1;
 		if (min1 == 1) {
 		    return min2;
 		} else if (min2 == 1) {
 		    return min1;
 		} 
 		
 		return Math.min(min1, min2);
    }
}


//ANOTHER APPROACH

 
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;
 		return depth(root);
    }
    
    int depth(TreeNode root) {
        if (root == null) {
 			return Integer.MAX_VALUE;
 		}       
 		
 		if (root.left == null && root.right == null) {
 		    return 1;
 		}

 		return Math.min( depth(root.left),  depth(root.right)) + 1;
    }
}