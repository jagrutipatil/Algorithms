/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode temp = fake;

        while (l1 != null || l2!=null) {
                if (l1 == null) {
                    temp.next = l2;
                    break;
                }
                if (l2 == null) {
                    temp.next = l1;
                    break;
                }

                if (l1.val < l2.val) {
                        temp.next = l1;
                        l1=l1.next;
                        temp = temp.next;
                } else {
                        temp.next = l2;
                        l2=l2.next;
                        temp = temp.next;
                }
        }
        return fake.next;       
    }
}
