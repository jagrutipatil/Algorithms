/*
  You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

  You may assume the two numbers do not contain any leading zero, except the number 0 itself.

  Follow up:
   What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

  Example:

  Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);               
        Stack<Integer> stack = new Stack<Integer>();
        ListNode root;

        if (len1 > len2) {
            ListNode temp = l1;
            int diff = len1 - len2;
            while (len1 != len2) {
                temp = temp.next;
                len1--;
            }
            ListNode newList = getList(temp, l2, stack);
            root = addOne(l1, newList, stack, diff);
            return checkCarryAndAddOne(root, stack);            
        } else if (len2 > len1) {
            ListNode temp = l2;
            int diff = len2 - len1;
            while (len1 != len2) {
                temp = temp.next;
                len2--;
            }
            ListNode newList = getList(l1, temp, stack);
            root = addOne(l2, newList, stack, diff);
            return checkCarryAndAddOne(root, stack);            
        } else {
            ListNode newList = getList(l1, l2, stack);
            int carry = 0;
            if (stack.size() != 0) {
                carry = stack.pop();
                root = new ListNode(carry);
                root.next = newList;
                return root;
            }               
            root = newList;            
        }
        return root;
    }

    private int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
          count++;
          node = node.next;
        }
        return count;
    }
    
    private ListNode checkCarryAndAddOne(ListNode node, Stack<Integer> stack) {
        if (stack.size() == 0)
            return node;
                
        int carry = stack.pop();
        
        int val = (node.val + carry ) % 10;
        carry = (node.val + carry) / 10;
        if (carry != 0)
           stack.push(carry);
        ListNode newNode = new ListNode(val);    
        newNode.next = node;
        return checkCarryAndAddOne(newNode, stack);
    }
    
    private ListNode addOne(ListNode node, ListNode newNode, Stack<Integer> stack, int diff) {
          if (diff == 0) {
              return newNode;
          }
          ListNode next = addOne(node.next, newNode, stack, diff - 1);

          int carry = 0;
          if (stack.size() > 0) {
              carry = stack.pop();
          }
          int value = (node.val + carry) % 10;
          carry = (node.val + carry)/10;
          if (carry != 0)
              stack.push(carry);

          ListNode temp = new ListNode(value);
          temp.next = next;
          return temp;
    }

    private ListNode getList(ListNode node1, ListNode node2, Stack<Integer> stack) {
        if (node1 == null)
            return null;
        ListNode next = getList(node1.next, node2.next, stack);

        int carry = 0;
        if (stack.size() != 0) {
            carry = stack.pop();
        }    
        int val = node1.val + node2.val + carry;
        carry = val / 10;
        if (carry != 0)
            stack.push(carry);
        
        ListNode node = new ListNode(val%10);
        node.next = next;
        return node;
    }
}


/*
  Another approach, 
  with space complexity O(len(l1) + len(l2))
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      Stack<Integer> stack1 = new Stack<Integer>();       
      Stack<Integer> stack2 = new Stack<Integer>();       

      while (l1 != null) {
        stack1.push(l1.val);
        l1 = l1.next;
      }

      while (l2 != null) {
        stack2.push(l2.val);
        l2 = l2.next;
      }

      int carry = 0;
      ListNode list = new ListNode(0);
      while (stack1.size() != 0 || stack2.size() != 0 || carry != 0) {
          int a1 = stack1.size()!= 0? stack1.pop() : 0;
          int b1 = stack2.size()!= 0? stack2.pop() : 0;

          int sum = a1 + b1+ carry;
          carry = sum / 10;
          
          list.val = sum % 10;
          ListNode head = new ListNode(0);
          
          head.next = list;
          list = head;
      }

      return list.val == 0? list.next: list;      
    }
}
