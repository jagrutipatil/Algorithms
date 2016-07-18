/*
Reverse Linked List
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, nxt = null;

        while (curr != null) {
        	nxt = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = nxt;
        }
        return prev;
    }
}
