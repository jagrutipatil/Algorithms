/*
Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Logic: Same as generting permutation, combination
       Important factors, right parentheses should be only generated when already left parentheses is there,
       if total length of left and right is equal to 2 * number of parentheses to generate, its valid item in solution set.
*/


public class Solution {
    public List<String> generateParenthesis(int n) {
    	 List<String> result = new ArrayList<String>();		 
 		 construct(n, 0, 0, new char[2*n], result);      
 		 return result;
    }

    void construct(int n, int left, int right, char[] arr, List<String> result) {
    	
    	int k = left + right;

    	if (k == n*2) {
    		result.add(new String(arr));
    		return;
    	}

    	if (left < n) {
    		arr[k] = '(';
    		construct(n, left+1, right, arr, result);
    	}

    	if (right < left) {
    	    arr[k] = ')';
    		construct(n, left, right+1, arr, result);
    	}
    }
}