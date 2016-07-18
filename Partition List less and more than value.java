/*
Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Logic: take two list, append all nodes to first list if val < x else to second list. At the end append next of first list to second list start
and point second list's end to null.
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
    	ListNode dummy1 = new ListNode(0);
    	ListNode dummy2 = new ListNode(0);
    	ListNode first = dummy1, second = dummy2;
    	ListNode curr = head;

    	while (curr != null) {
    		if (curr.val < x) {
    			first.next = curr;
    			first = first.next;
    		} else {
    			second.next = curr;
    			second = second.next;
    		}
    		curr = curr.next;
    	}
    	second.next = null;
    	first.next = dummy2.next;
    	return dummy1.next;
    }
}
