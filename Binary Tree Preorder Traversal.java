public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
 		TreeNode temp = root;
 		Stack<TreeNode> stack = new Stack<TreeNode>();
 		List<Integer> result = new ArrayList<Integer>();

 		while (temp != null) {
 			result.add(temp.val);

 			if (temp.right != null)
 				stack.push(temp.right);

 			if (temp.left != null) {
 				temp = temp.left;
 			} else if (stack.size() > 0) {
 				temp = stack.pop();
 			} else {
 				temp = null;
 			}
 		}

 		return result;       
    }
}