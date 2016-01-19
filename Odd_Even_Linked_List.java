/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
 		if (head == null || head.next == null)
 			return head;

 		ListNode odd = head, even = head.next, oddt = odd, event = even, temp = even.next;
 		int count=3;

 		while (temp != null) {
 			if (count % 2 != 0) {
 				oddt.next = temp;
 				oddt = oddt.next;
 			} else {
 				event.next = temp;
 				event = event.next;
 			}
 			count++;
 			temp = temp.next;
 		}
 		oddt.next = even;
 		event.next = null;
 		return odd;
    }
}