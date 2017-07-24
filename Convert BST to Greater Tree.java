/*
  Convert BST to Greater Tree
  
  Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

  Example:

  Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

  Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
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
    public TreeNode convertBST(TreeNode root) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode node = root;

      while (node != null) {
        stack.push(node);
        node = node.right;
      }       

      int sum = 0;
      while (stack.size() != 0) {
        node = stack.pop();
        node.val = node.val + sum;
        sum = node.val;
        node = node.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }               
      }
      return root;
    }

}
