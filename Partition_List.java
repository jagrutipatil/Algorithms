/*
Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.


For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode partition(ListNode head, int x) {
		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode lp = left;
		ListNode rp = right;

		while (head != null) {
			if (head.val < x) {
				lp.next = head;
				lp = lp.next;
			} else {
				rp.next = head;
				rp = rp.next;
			}
			head = head.next;
			lp.next = rp.next = null;
		}
		
		lp.next = right.next;
		return left.next;
    }
}