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