/*	
	Add One Row to Tree

	Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

	The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

	Example 1:

	Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   


 Example 2:
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1

Note:
	The given d is in range [1, maximum depth of the given tree + 1].
	The given binary tree has at least one tree node.

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int currDepth = 1;
        
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        
		if (root != null) {
			queue.add(root);
		}        

		while (queue.size() > 0 && currDepth <= d) {
			int length = queue.size();
			currDepth++;			
			for (int i = 0; i < length && currDepth <= d; i++) {
				TreeNode temp = queue.remove();				

				if (currDepth == d) {
					TreeNode tl = new TreeNode(v);
					TreeNode tr = new TreeNode(v);
					TreeNode tll = temp.left;
					TreeNode trr = temp.right;
					temp.left = tl;
					temp.right = tr;
					tl.left = tll;
					tr.right = trr;
					continue;
				} 

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}

			}
		}
		return root;
    }
}