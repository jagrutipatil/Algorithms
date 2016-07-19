/*
Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Challange: in O(1) space

Logic:
1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node
2) Now copy the arbitrary link in this fashion

	original->next->arbitrary = original->arbitrary->next;  /*TRAVERSE TWO NODES*/
	
	This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
3) Now restore the original and copy linked lists in this fashion in a single loop.
	original->next = original->next->next;
    copy->next = copy->next->next;


*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head, newNode = null;

        if (head == null) {
        	return null;
        }

        while (curr != null) {
        	newNode = new RandomListNode(curr.label);
        	newNode.next = curr.next;
        	curr.next = newNode;
        	curr = newNode.next;
        }

        curr = head; 
        while (curr != null) {
        	if (curr.random != null) {
        		curr.next.random = curr.random.next;
        	}
        	curr = curr.next.next;
        }

        curr = head;
        RandomListNode newList = curr.next;
        while (curr != null) {
        	newNode = curr.next;
        	curr.next = newNode.next;
        	if (newNode.next != null) {
        		newNode.next = newNode.next.next;
        	} 
        	curr = curr.next;       	
        }
        return newList;
    }
}