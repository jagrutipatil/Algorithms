/*
Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(root, 0, result);        
		Collections.reverse(result);
		return result;
    }

    void dfs(TreeNode root, int depth, List<List<Integer>> result) {
    	if (root == null) {
    		return;
    	}
    	List<Integer> list;

    	if (depth < result.size()) {
    		list = result.get(depth);
    	} else {
    		list = new ArrayList<Integer>();
    		result.add(list);
    	}
    	
    	list.add(root.val);
    	dfs(root.left, depth+1, result);
    	dfs(root.right, depth+1, result);
    }

}