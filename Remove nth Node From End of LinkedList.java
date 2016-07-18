/*
Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

Logic:
keep two pointers. first pointer - k position ahead of second pointer and loop over till first pointer reaches end of linked list
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode first = head, second = head, prev = null;

    	if (head == null) {
    		return null;
    	}

    	while (n != 0 && first != null) {
    		first = first.next;
    		n--;
    	}

    	while (first != null) {
    		prev = second;
    		first = first.next;
    		second = second.next;
    	}

    	if (prev == null) {
    		head = second.next;
    	} else {
    		prev.next = second.next;
    	}
    	return head;
    } 
}
