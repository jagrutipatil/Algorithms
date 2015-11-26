/*
Unique Binary Search Trees II

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
           return new ArrayList<TreeNode>(); 
        }
        return generate(1, n);
    }

    List<TreeNode> generate(int start, int end) {
    	List<TreeNode> list = new ArrayList<TreeNode>();

    	if (start > end) {
    		list.add(null);
    		return list;
    	}

    	for (int i = start; i <=end;i++) {
    		List<TreeNode> lefts = generate(start, i -1);
    		List<TreeNode> rights = generate(i+1, end);
    		for (TreeNode left: lefts) {
    			for (TreeNode right: rights) {
    				TreeNode node = new TreeNode(i);
    				node.left = left;
    				node.right = right;
    				list.add(node);
    			}
    		}
    	}
    	return list;
    }
}