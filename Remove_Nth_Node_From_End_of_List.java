/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
 		
 		if (head == null) 
 			return null;

 		ListNode prev = null, slow = head, fast = head, next = head.next;
 		int i = 0;


 		while (i < n && fast != null) {
 			fast = fast.next;
 			i++;
 		}       

 		while (fast!=null) {
 			prev = slow;
 			fast = fast.next;
 			slow = slow.next;
 			next = slow.next;
 		}

 		if (slow!=null) {
 			if (prev != null) {
 				prev.next = next;
 			} else {
 				head = next;
 			}
 		}

 		return head;
    }
}