/*
	Binary Tree Right Side View

	Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Logic: Use Level order traversal and only pic one element from level i.e rightmost 
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
    public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if (root != null)
			queue.add(root);

		while (queue.size() > 0) {
			int size = queue.size();
			int right = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				if (node.left != null)
					queue.add(node.left);
					
				if (node.right != null)
					queue.add(node.right);
					
				right = node.val;
			}
			result.add(right);
		}
		return result;
    }
}

________________________________________________________________________________________________

//without space

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightSideView(root, 0, result);
		return result;
    }
    
    private void rightSideView(TreeNode node, int level, List<Integer> result) {
        if (node == null)
            return;
        if (level == result.size()) {
            result.add(node.val);
        }
        
        rightSideView(node.right, level+1, result);    
        rightSideView(node.left, level+1, result);    
    }
}