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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root != null) {
        	stack.push(root);
        }

        while (stack.size() > 0) {
        	TreeNode node = stack.pop();
        	result.add(node.val);

        	if (node.right != null) {
        		stack.push(node.right);
        	}

        	if (node.left != null) {
        		stack.push(node.left);
        	}
        }
        return result;
    }
}