public class Solution {
    public int longestValidParentheses(String s) {
 		Stack<Integer> stack = new Stack<Integer>();
 		int left = -1, maxLen = 0;

 		for (int i = 0; i < s.length(); i++) {
 		    char ch = s.charAt(i);
 			if (ch == '(') {
 				stack.push(i);
 			} else if (stack.isEmpty()) {
 				left = i;
 			} else {
 				stack.pop();
 				if (stack.isEmpty()) {
 					maxLen = Math.max(maxLen, i - left);
 				} else {
 					maxLen = Math.max(maxLen, i - stack.peek());
 				}
 			}
 		}
 		return maxLen;
    }
}