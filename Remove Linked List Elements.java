/*
Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

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
    public ListNode removeElements(ListNode head, int val) {
 		if (head == null || (head.next == null && head.val == val)) {
 			return null;
 		}
 			
 		ListNode temp = head, prev = null, next = head.next;

 		while (temp != null) {
 			if (temp.val == val) {
 				if (prev == null) {
 					head = next;
 				} else {
 					prev.next = next;
 				}
 			} else {
 				prev = temp;
 			}

 			temp = next;
 			if (next != null) {
 				next = next.next;
 			}
 		}

 		return head;
    }
}

___________________________________________________________

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
    	ListNode temp = head, prev = null, next = null;

    	while (temp != null) {
    		next = temp.next;
    		if (temp.val == val) {
    			if (prev == null) {
    				head = next;
    			} else {
    				prev.next = next;
    			}
    		} else {
    		    prev = temp;
    		}
    		temp = temp.next;
    	}
    	return head;
    }
}