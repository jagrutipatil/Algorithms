/*
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

Logic: Use Priority Queue
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
    	ListNode head = new ListNode(0);
    	head.next = null;
    	ListNode dummy = head;
    	
    	if (lists.size() == 0)
    	    return null;
    	    
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

    	for (ListNode node : lists) {
    		if (node != null)
    			queue.offer(node);
    	}

    	while (queue.size() > 0) {
    		ListNode temp = queue.poll();
    		dummy.next = temp;
    		dummy = dummy.next;

    		if (temp.next != null) {
    			queue.offer(temp.next);
    		}
    	}
    	return head.next;
    }
}
