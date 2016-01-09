/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode temp = head;

        while (l1 != null || l2 != null || carry != 0) {
        	int a1 = l1!=null ? l1.val : 0;
        	int a2 = l2!=null ? l2.val : 0;

        	int sum = (a1+a2+carry) %10;
        	carry = (a1+a2+carry)/10;
        	temp.next = new ListNode(sum);
        	temp.next.next = null;
        	temp = temp.next;
        	if (l1 != null) 
        		l1=l1.next;
        	if (l2 != null)
        		l2=l2.next;
        }

        return head.next;
    }
}