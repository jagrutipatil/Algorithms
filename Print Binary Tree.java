/*
Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
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
 
class Solution {
    
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (root == null)
            return result;
        
        int height = getHeight(root);                
        int width = (int)Math.pow(2, height)-1;         
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < width; i++) {
            list.add("");
        }
   
        for (int i = 0; i < height; i++) {
            List<String> columns = new ArrayList<String>(list);
            result.add(new ArrayList<String>(columns));
        }        
        getTree(root, result, 0, 0, width-1);
        return result;
    }
    
    private void getTree(TreeNode node, List<List<String>> result, int height, int left, int right) {
        if (node == null)
            return;
        List<String> columns = result.get(height);
        columns.set((left+right)/2, node.val + "");
        getTree(node.left, result, height+1, left, ((left+right)/2)-1);
        getTree(node.right, result, height+1, ((left+right)/2)+1, right);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }            
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        return 1 + Math.max(left, right);
    }
}
