/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
    	TreeNode temp = root;
    	TreeNode t = null;
    	while (temp != null) {
    		stack.push(temp);
    		temp = temp.left;
    	}    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.size() != 0)
        	return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode temp = null;
        
        if (node.right != null) {
            temp = node.right;
            while (temp != null) {
    		        stack.push(temp);
    		        temp = temp.left;
    	    }
        }
        
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */