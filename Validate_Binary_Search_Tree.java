

public class Solution {
    public boolean isValidBST(TreeNode root) {
 		return checkRecursive(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);       
    }

    public boolean checkRecursive(TreeNode root, double min, double max) {
    	if (root == null) {
    		return true;
    	} 
    	
    	if (root.val <= min || root.val >= max) {
    		return false;
    	} 
    	 
       return checkRecursive(root.left, min, root.val) && checkRecursive(root.right, root.val, max);    
    	
    }
}