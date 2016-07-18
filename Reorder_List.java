/*
	Reorder List

	Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln

	reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

	Logic:
	Break the list into two parts, reverse second part, merge first part and second(reversed) part
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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
    	ListNode slow = head, fast = head, t1 = null, t2 = null;

    	if (head == null)
    		return;
    		
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	ListNode first = head;
    	ListNode second = slow.next;
    	slow.next = null;

    	second = reverse(second);
    	t1 = first;
    	t2 = second;
    	ListNode dummy = new ListNode(0);
    	int index = 0;

    	while (t1 != null && t2 != null) {
    		if (index % 2 == 0) {
    			dummy.next = t1;
    			t1 = t1.next;
    		} else {
    			dummy.next = t2;
    			t2 = t2.next;
    		}
    		dummy = dummy.next;
    		index++;
    	}
    	if (t2 == null) {
    		dummy.next = t1;
    	} else {
    		dummy.next = t2;
    	}
    }

    private ListNode reverse(ListNode node) {
    	ListNode prev = null, curr = node, nxt = null;

    	while (curr != null) {
    		nxt = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = nxt;
    	}

    	return prev;
    }
}
