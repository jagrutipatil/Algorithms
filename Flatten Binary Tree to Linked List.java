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
    public void flatten(TreeNode root) {
 		if (root == null)
 			return;

 		TreeNode left = root.left;
 		TreeNode right = root.right;
 		
 		flatten(left);
 		root.right = left;
 		root.left = null;
 		
 		// From root node again traversing till rightmost end everytime, lot of time wastage
 		TreeNode temp = root;
 		while (temp != null && temp.right != null) {
 			temp = temp.right;
 		}

 		flatten(right);
 		temp.right=right;
    }
}
__________________________________________________________
// Alternate recursive way

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) 
            return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
    }
}
___________________________________________________________
//Iterative
public class Solution {
    public void flatten(TreeNode root) {
 		traverseTail(root);
    }

    public TreeNode traverseTail(TreeNode node) {
    	if (node == null)
    		return null;

    	TreeNode left = node.left;	
    	TreeNode right = node.right;	

    	node.left = null;
    	node.right = left;

    	if (node.right != null) {
    		node = traverseTail(node.right);
    	}

    	node.right = right;
    	if (node.right != null) {
    		node = traverseTail(node.right);
    	}
    	return node;
    }
}

// clean solution
class Solution {
    public void flatten(TreeNode root) {
      if (root == null)
          return;
       flatten(root.left);
       TreeNode left = root.left;
       TreeNode right = root.right; 
       
        root.left = null;
        root.right = left;
        while(root.right != null) {
            root = root.right;
        }
        root.right = right;
        flatten(root.right);
    }
}
