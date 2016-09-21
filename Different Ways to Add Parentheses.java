/*
	Different Ways to Add Parentheses

	Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

	Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]


Logic: Use recurcive approach to split the string accorss operator, store the partially calculated result into cache to avoid duplicate calculations
*/

public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
 		Map<String, List<Integer>> cache = new HashMap<String, List<Integer>>();

 		return diffWaysToCompute(input, cache);
    }

    private List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> cache) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (input == null || input.length() == 0) {
    		return result;
    	}

    	if (cache.get(input) != null)
    		return cache.get(input);

    	if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
    		result.add(Integer.parseInt(input));
    		return result;
    	}

    	for (int i = 0; i < input.length(); i++) {
    		char ch = input.charAt(i);
    		if (ch == '+' || ch == '-' || ch == '*') {
    			List<Integer> left = diffWaysToCompute(input.substring(0, i), cache);
    			List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()), cache);

    			for (int no1 : left) {
    				for (int no2 : right) {
    					int output = 0;
    					if (ch == '+') {
    						output = no1 + no2;
    					} else if (ch == '-') {
    						output = no1 - no2;
    					} else if (ch == '*') {
    						output = no1 * no2;
    					}
    					result.add(output);
    				}
    			}
    		}    		
    	}
    	
    	cache.put(input, result);
    	return result;
    }
}