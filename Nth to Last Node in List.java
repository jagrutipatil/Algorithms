/*
Nth to Last Node in List

Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.


Logic: Use two pointers, advance first pointer till nth and then move both pointers until first pointer is pointing to end.

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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
    	ListNode first = head, second = head;
		
		if (n == 0)    
			return null;
			
    	while (n > 0 && first != null) {
    		first = first.next;
    		n--;
    	}

    	while (first != null) {
    		second = second.next;
    		first = first.next;
    	}
    	return second;
    }
}
