/*
Calculate unival Subtrees in a tree, unival subtrees are trees those have parent, left and right value are same

*/



int subTree(TreeNode node) {
	int count = 0;
	if (node == null) {
		return 0;
	}

	if (node.left == null && node.right == null) {
		count++;
	} else if (node.left != null && node.right != null && node.val == node.left.val && node.left.val == node.right.val) {
			   count++;
	} else if (node.left != null && node.right == null && node.val == node.left.val) {
				count++;
	} else if (node.right != null && node.left == null && node.val == node.right.val) {
				count++;
	}

	if (node.left != null)
		count = count + subTree(node.left);

	if (node.right != null)
		count = count + subTree(node.right);
	
	return count;
} 