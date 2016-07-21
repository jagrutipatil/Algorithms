/*
Search Range in Binary Search Tree

Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST.
Return all the keys in ascending order.

Logic: Traverse all paths those fit in the range
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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */

    ArrayList<Integer> result = null;

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        result = new ArrayList<Integer>();
        findRangeValues(root, k1, k2);

        return result;
    }

    void findRangeValues(TreeNode node, int k1, int k2) {
    	if (node == null)
    		return;

    	if (node.val > k1)
    		findRangeValues(node.left, k1, k2);

    	if (node.val >= k1 && node.val <= k2)
    		result.add(node.val);

    	if (node.val < k2)
    		findRangeValues(node.right, k1, k2);		
    }
}
