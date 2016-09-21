/*
	 Basic Calculator II

	 Implement a basic calculator to evaluate a simple expression string.

	The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

	You may assume that the given expression is always valid.

	Some examples:
	"3+2*2" = 7
	" 3/2 " = 1
	" 3+5 / 2 " = 5

	Logic:
		Only add calculation to result when * or / are computed else next operator is + or -
		
*/
public class Solution {
    public int calculate(String s) {
 		int result = 0, prev = 0;
 		int i = 0;
 		char op = '+';
 		s = s.trim();
 		
 		while (i < s.length()) {
 			char ch = s.charAt(i);
 			if (Character.isDigit(ch)) { 				
 				StringBuilder sb = new StringBuilder();
 				while (i < s.length() && Character.isDigit(s.charAt(i))) {
 					sb.append(s.charAt(i));
 					i++;
 				}

 				int curr = Integer.parseInt(sb.toString());
 				if (op == '+') {
 					result += prev;
 					prev = curr;
 				} else if (op == '-') {
 					result += prev;
 					prev = -curr;
 				} else if (op == '*') {
 					prev = prev * curr;
 				} else if (op == '/') {
 					prev = prev/curr;
 				}
 			} else if (ch == '+') {
 				op = '+';
 				i++;
 			} else if (ch == '-') {
 				op = '-';
 				i++;
 			} else if (ch == '/') {
 				op = '/';
 				i++;
 			} else if (ch == '*') {
 				op = '*';
 				i++;
 			} else {
 				i++;
 			}
 		}
 		result += prev;
 		return result;       
    }
}