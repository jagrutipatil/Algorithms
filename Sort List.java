/*
Sort Linked List in O(nlogn) time.

Logic: use merge sort
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
     * @return: You should return the head of the sorted linked list,
     *               using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode second = sortList(mid.next);
        mid.next = null;
        ListNode first = sortList(head);
        return merge(first, second);
    }
    

    ListNode findMid(ListNode node) {
    	ListNode slow = node, fast = node.next;

    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }

    ListNode merge(ListNode node1, ListNode node2) {
    	ListNode dummy = new ListNode(0);
    	ListNode temp = dummy;

    	while (node1 != null && node2 != null) {
    		if (node1.val <= node2.val) {
    		 	temp.next = node1;
    		 	node1 = node1.next;	
    		} else {
    			temp.next = node2;
    			node2 = node2.next;
    		}
    		temp = temp.next;
    	}

    	if (node1 == null) {
    		temp.next = node2;
    	} else if (node2 == null) {
    		temp.next = node1;
    	}
    	return dummy.next;
    }
}
