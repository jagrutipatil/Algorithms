/*
Linked List Cycle

Given a linked list, determine if it has a cycle in it.

Logic: Take two pointers, one - slow n second- fast. iterate till they are not same. if they are same then its cycle else no loop.
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) { 
        if (head == null)
            return false;
            
        ListNode slow = head, fast = head.next;
        
        while (slow != null && fast != null && slow != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (slow != null && fast != null && slow == fast) {
            return true;
        }
        
        return false;
    }
}
