/*
Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/


public class Solution {
    public boolean isValid(String s) {
 		Map<Character, Character> map = new HashMap<Character, Character>();
 		map.put('(', ')');       
 		map.put('[', ']');       
 		map.put('{', '}');       
 		char current;
 		Stack<Character> stack = new Stack<Character>();

 		for (int i = 0; i < s.length(); i++) {
 			current = s.charAt(i);

 			if (map.containsKey(current)) {
 				stack.push(current);
 			} else if (map.containsValue(current)) {
 				if (!stack.isEmpty() && current == map.get(stack.peek())) {
 					stack.pop();
 				} else {
 					return false;
 				}
 			}
 		}
 		return stack.isEmpty();
    }
}