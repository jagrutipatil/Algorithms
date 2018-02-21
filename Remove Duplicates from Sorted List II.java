/*
  Remove Duplicates from Sorted List II
  
  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

  For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.    
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head, prev = null;
        
        while (temp != null) {
            ListNode next = temp.next;
            if (next != null && temp.val == next.val) {
                while (next != null && temp.val == next.val) {
                    next = next.next;
                }                
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;                    
                }                
            } else {
                prev = temp;    
            }
            temp = next;
        }
        return head;
    }
}
