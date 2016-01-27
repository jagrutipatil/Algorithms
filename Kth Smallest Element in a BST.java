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
	Stack<Integer> stack = new Stack<Integer>();
	int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
 		       int small = 0;
 		       inorder(root, k);
 		       if (stack.size() > 0)
 		       	   small = stack.pop();
 		       return small;
    }

    public void inorder(TreeNode node, int k) {
    	if (node == null)
    		return;
    	inorder(node.left, k);
    	count++;
    	if (count == k) {
    		stack.push(node.val);
    		return;
    	}

    	inorder(node.right, k);
    }
}