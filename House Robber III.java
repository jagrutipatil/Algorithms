/*
	House Robber III

	The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.


Logic: 
		https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/2
		
		If we were able to maintain the information about the two scenarios for each tree root, let's see how it plays out. Redefine rob(root) as a new function which will return an array of two elements, the first element of which denotes the maximum amount of money that can be robbed if "root" is not robbed, while the second element signifies the maximum amount of money robbed if root is robbed.

		Let's relate rob(root) to rob(root.left) and rob(root.right), etc. For the 1st element of rob(root), we only need to sum up the larger elements of rob(root.left) and rob(root.right), respectively, since root is not robbed and we are free to rob the left and right subtrees. For the 2nd element of rob(root), however, we only need to add up the 1st elements of rob(root.left) and rob(root.right), respectively, plus the value robbed from "root" itself, since in this case it's guaranteed that we cannot rob the nodes of root.left and root.right.

		As you can see, by keeping track of the information of both scenarios, we decoupled the subproblems and the solution essentially boiled down to a greedy one.


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
    public int rob(TreeNode root) {
 		int[] result = robNode(root);       
 		return Math.max(result[0], result[1]);
    }

    private int[] robNode(TreeNode node) {
    	if (node == null)
    		return new int[2];

    	int[] left = robNode(node.left);
    	int[] right = robNode(node.right);
    	int[] result = new int[2];

    	result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    	result[1] = node.val + left[0] + right[0];
    	return result;
    }
}