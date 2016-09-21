/*
	Basic Calculator

	Implement a basic calculator to evaluate a simple expression string.

	The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

	You may assume that the given expression is always valid.

	Some examples:
		"1 + 1" = 2
		" 2-1 + 2 " = 3
		"(1+(4+5+2)-3)+(6+8)" = 23
*/

public class Solution {
    public int calculate(String s) {
 		int result = 0, sign = 1, number = 0;
 		Stack<Integer> stack = new Stack<Integer>();

 		for (int i = 0; i < s.length(); i++) {
 			if (Character.isDigit(s.charAt(i))) {
 				number = s.charAt(i) - '0';
 				while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
 					number = number*10 + s.charAt(i+1) - '0';
 					i++;
 				}
 				result = result + number*sign;
 			} else if (s.charAt(i) == '+') {
 				sign = 1;	
 			} else if (s.charAt(i) == '-') {
 				sign = -1;	
 			} else if (s.charAt(i) == '(') {
 				stack.push(result);
 				stack.push(sign);
 				result = 0;
 				sign = 1;
 			} else if (s.charAt(i) == ')') {
 				result = result * stack.pop() + stack.pop();
 			}
 		}

 		return result;       
    }
}