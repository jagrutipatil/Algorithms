//find longest consequtive number sequence in binary tree


class Solution {
	private int max = 0;

	int maxSequenceInBT(TreeNode node) {
		maxSequenceInBT(node, null, 0);
		return max;
	}

	void maxSequenceInBT(TreeNode curr, TreeNode prev, int count) {
		if (curr == null)
			return;

		if (prev != null && curr.val == prev.val+1) {
			count += 1;
		} else {
			count = 1;
		}

		max = Math.max(count, max);

		maxSequenceIn(curr.left, curr, count);
		maxSequenceIn(curr.right, curr, count);
	}
}