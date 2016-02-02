public class Solution {
    public int calculate(String s) {
 		Stack<Integer> stack = new Stack<Integer>();
 		int n = s.length(), no = 0;
 		char sign = '+';

 		for (int i = 0; i < n; i++) {
 			if (Character.isDigit(s.charAt(i))) {
 				no = no*10 + s.charAt(i) - '0';
 			}

 			if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == n-1) {
 				if (sign == '+') {
 					stack.push(no);
 				} else if (sign == '-') {
 					stack.push(-1* no);
 				} else if (sign == '*') {
 					stack.push(stack.pop()*no);
 				} else if (sign == '/') {
 					stack.push(stack.pop()/no);
 				} 
 				sign = s.charAt(i);
 				no = 0;
 			}
 		}

 		int result = 0;
 		for (int i : stack) {
 			result += i;
 		}

 		return result;
    }
}