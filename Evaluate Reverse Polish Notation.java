/*
    Evaluate Reverse Polish Notation
    
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    
    Example
        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    
    Logic: 
        1. Use stack, 
        2. if oprand push to stack, else pop two values from the stack perform operation and push result back to stack
*/

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