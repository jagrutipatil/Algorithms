/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Given inorder [1,2,3] and postorder [1,3,2], return a tree:
  2
 / \
1   3

Logic: Divide and construct. 
        1. In post order rightmost number is root of tree/subtree always. Creaet the root node.
        2. Find out the root in inorder and determine left tree length and right tree length.
        3. recursively apply same logic for left inorder sequencce and right inorder sequence, adjust the postorder pointer.
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder, postorder, 0, inorder.length -1, postorder.length - 1);
    }

    private TreeNode constructTree(int[] inorder, int[] postorder, int is, int ie, int pe) {
        if (is <= ie && pe >= 0) {
            TreeNode root = new TreeNode(postorder[pe]);

            int i = is;
            for (; i <= ie && inorder[i] != postorder[pe]; i++);

            root.left = constructTree(inorder, postorder, is, i - 1, pe - (ie - i) - 1);
            root.right = constructTree(inorder, postorder, i + 1, ie, pe - 1);
            return root;
        }
        return null;
    }
}