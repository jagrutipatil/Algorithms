public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
            
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode fast = dummy, slow = dummy;
    	int len = calcLen(head);

    	k = k %len;
    	int i = 0;

    	while (fast.next != null) {
    		if (i >= k)
    			slow = slow.next; 
    		fast = fast.next;
    		i++;
    	}

    	fast.next = dummy.next;
    	dummy.next = slow.next;
    	slow.next = null;
    	return dummy.next;
    }

    int calcLen(ListNode node) {
    	int len = 0;    	
    	while (node != null) {
    		node = node.next;
    		len++;
    	}
    	return len;
    }
}