/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public void connect(TreeLinkNode root) {
		TreeLinkNode dummy = new TreeLinkNode(0);
		dummy.next = root;

		while (dummy.next != null) {
			TreeLinkNode n = dummy.next;
			dummy.next = null;
			TreeLinkNode curr = dummy;

			for (;n != null;n = n.next) {
				if (n.left != null) {
					curr.next = n.left;
					curr = curr.next;
				}

				if (n.right != null) {
					curr.next = n.right;
					curr = curr.next;
				}
			}
		}
    }
}