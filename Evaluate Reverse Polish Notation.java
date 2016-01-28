//Evaluate Reverse Polish Notation

public class Solution {
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<Integer>();
    	if (tokens.length == 0)
    	   return 0;
 		for (int i = 0; i < tokens.length; i++) {
 			if (isNumber(tokens[i])) {
 				stack.push(Integer.parseInt(tokens[i]));
 			} else {
 				Integer opr2 = stack.pop();
 				Integer opr1 = stack.pop();
 				stack.push(calc(opr1, opr2, tokens[i]));
 			}
 		}
 		return stack.pop();
    }

    public boolean isNumber(String s) {
    	try {
    		Integer.parseInt(s);
    	} catch(NumberFormatException e) {
    		return false;
    	}
    	return true;
    }

    public Integer calc(Integer op1, Integer op2, String op) {
    	if (op.equals("+")) {
    		return op1 + op2;
    	} else if (op.equals("-")) {
    		return op1 - op2;
    	} else if (op.equals("*")) {
    		return op1 * op2;
    	} else if (op.equals("/")) {
    		return op1 / op2;
    	}
    	return 0;
    }
}