/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
    	ListNode current = head, temp = null;

    	while (current != null) {
    		temp = current;
    		while (temp != null && temp.val == current.val) {
    			temp = temp.next;
    		}
    		current.next = temp;
    		current = current.next;
    	}
    	return head;
    }  
}