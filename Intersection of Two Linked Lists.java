/*
Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.

 Notice

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Have you met this question in a real interview? Yes

Example
The following two linked lists:

The following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Method 1: First calculate the length of two lists and find the difference. Then start from the longer list at the diff offset, iterate though 2 lists and find the node.


Method2: 
	1. Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
	
	2. When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
	If at any point pA meets pB, then pA/pB is the intersection node.
	
	3.To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
	
	4.If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.
	Complexity Analysis

	Time complexity : O(m+n)O(m+n).
	Space complexity : O(1)O(1).
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
    	int len1 = 0, len2 = 0;

    	while (temp1 != null) {
    		len1++;
    		temp1 = temp1.next;
    	}

    	while (temp2 != null) {
    		len2++;
    		temp2 = temp2.next;
    	}
        
        temp1 = headA;
        temp2 = headB;
    	if (len1 > len2) {
    		while (len1 != len2 && temp1 != null) {
    			temp1 = temp1.next;
    			len1--;
    		}
    	} else if (len1 < len2) {
    		while (len2 != len1 && temp2 != null) {
    			temp2 = temp2.next;
    			len2--;
    		}    		
    	}

    	while (temp1 != null && temp2 != null && temp1 != temp2) {
    		temp1 = temp1.next;
    		temp2 = temp2.next;
    	}

    	if (temp1 == null || temp2 == null)
    		return null;
    		
    	return temp1;
    }  
}


_______________________________________________________________________________
//Cleaner solution
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        
        if (temp1 == null || temp2 == null)
            return null;
            
        while (temp1.val != temp2.val) {
        	temp1 = temp1.next;
        	temp2 = temp2.next;
        	if (temp1 == null && temp2 == null) {
        		return null;
        	} else if (temp2 == null) {
        		temp2 = headA;
        	} else if (temp1 == null) {
        		temp1 = headB;
        	}
        }
        return temp1;
    }  
}