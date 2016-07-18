/*
Merge Two Sorted Lists

Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Logic: merge like merg sort

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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode k = dummy;

        while (l1 != null && l2 != null) {
        	if (l1.val <= l2.val) {
        		k.next = l1;
        		l1 = l1.next;        		
        	} else {
        		k.next = l2;
        		l2 = l2.next;        		
        	}
        	k = k.next;
        }

        if (l1 == null)
        	k.next = l2;
        if (l2 == null) 
        	k.next = l1;

        return dummy.next;
    }
}