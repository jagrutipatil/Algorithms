/*
	Evaluate Division

	Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

	According to the example above:

	equations = [ ["a", "b"], ["b", "c"] ],
	values = [2.0, 3.0],
	queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
	
	The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


*/


public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
 		Set<String> set = new HashSet<String>();
 		double[] result = new double[queries.length];
 		for (String[] key : equations) {
 			set.add(key[0]);
 			set.add(key[1]);
 		}       

 		for (int i = 0; i < queries.length; i++) {
 			String[] key = queries[i];
 			if (!set.contains(key[0]) || !set.contains(key[1])) {
 				result[i] = -1;
 			} else {
 				Stack<Integer> stack = new Stack<Integer>();
 				result[i] = calcEquation(equations, values, queries, stack, key[0], key[1]);
 			}
 		}

 		return result;
    }

    private double calcEquation(String[][] equations, double[] values, String[][] queries, Stack<Integer> stack, String key1, String key2) {
    	//search for direct relation
    	for (int i = 0; i < equations.length; i++) {
    		if (equations[i][0].equals(key1) && equations[i][1].equals(key2)) return values[i];
    		if (equations[i][0].equals(key2) && equations[i][1].equals(key1)) return 1/values[i];
    	}

    	//search for indirect relation

    	for (int i = 0; i < equations.length; i++) {
    		if (!stack.contains(i) && equations[i][0].equals(key1)) {
    			stack.push(i);
    			double temp = values[i] * calcEquation(equations, values, queries, stack, equations[i][1], key2);
    			if (temp > 0)
    				return temp;
    			else 
    				stack.pop();
    		}

    		if (!stack.contains(i) && equations[i][1].equals(key1)) {
    			stack.push(i);
    			double temp = calcEquation(equations, values, queries, stack, equations[i][0], key2)/values[i];
    			if (temp > 0)
    				return temp;
    			else 
    				stack.pop();
    		}
    	}
    	return -1;
    }
}