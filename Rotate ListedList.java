/*
Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

e.g: Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.

Logic: 
 1. get pointer on (len -k) th position with the help of two pointers.
 	1.1 First pointer move k steps.
 	1.2 Then 2 pointers start moving together. When 1st pointer reaches the end, then 2nd pointer should be at (len-k)th position
 2. Let 2nd pointer be head, and move original head to tail of the list

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
 		int len = findLength(head);
 		
 		if (len > 0) {
 		    k = k % len;
 		}
 		    

 		if (k > 0 && head != null) {
 			ListNode first = head, second = head;

 			while (k > 0 && first != null) {
 				k--;
 				first = first.next;
 			}

 			while (first.next != null) {
 				second = second.next;
 				first = first.next;
 			}

 			ListNode sHead = second.next;
 			second.next = null;

 			ListNode temp = sHead, last = null;

 			while (temp != null) {
 			    last = temp;
 				temp = temp.next;
 			}
 			
 			if (last != null) {
 			    last.next = head;
 			    head = sHead;
 			}
 		}
 		return head;
    }

    private int findLength(ListNode node) {
    	int len = 0;
    	while (node != null) {
    		node = node.next;
    		len++;
    	}
    	return len;
    }

    private ListNode reverse(ListNode node) {
    	ListNode prev = null, nxt = null;
    	while (node != null) {    		
    		nxt = node.next;
    		node.next = prev;
    		prev = node;
    		node = nxt; 
    	}
    	return prev;
    }
}