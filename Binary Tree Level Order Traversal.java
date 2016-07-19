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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root != null) {
        	queue.add(root);
        }

        while (queue.size() > 0) {
        	int size = queue.size();
        	ArrayList<Integer> list = new ArrayList<Integer>();

        	for (int i = 0; i < size; i++) {
        		TreeNode node = queue.remove();
        		list.add(node.val);
        		if (node.left != null) {
        			queue.add(node.left);
        		}
        		if (node.right != null) {
        			queue.add(node.right);
        		}        		
        	}
        	result.add(list);
        }
        return result;
    }
}