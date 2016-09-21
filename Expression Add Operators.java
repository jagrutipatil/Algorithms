/*
	Expression Add Operators

	Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

	Examples: 

			"123", 6 -> ["1+2+3", "1*2*3"] 
			"232", 8 -> ["2*3+2", "2+3*2"]
			"105", 5 -> ["1*0+5","10-5"]
			"00", 0 -> ["0+0", "0-0", "0*0"]
			"3456237490", 9191 -> []

    
	Logic: 
		This problem has a lot of edge cases to be considered:

		overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
		0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
		a little trick is that we should save the value that is to be multiplied in the next recursion.

	Complexity: 4^n
*/

public class Solution {
    public List<String> addOperators(String num, int target) {
 		List<String> result = new ArrayList<String>();
 		if (num == null || num.length() == 0)
 		    return result;
 		addOperators(num, "", target, result, 0, 0, 0);
 		return result;       
    }

    private void addOperators(String num, String path, int target, List<String> result, int pos, long eval, long mult) {
    	if (pos == num.length()) {
    		if (eval == target)
    			result.add(path);
    		return;
    	}

    	for (int i = pos; i < num.length(); i++) {
    		if (i != pos && num.charAt(pos) == '0') 
    		    break;
    		    
    		long no = Long.parseLong(num.substring(pos, i+1));
    		if (pos == 0) {
    			addOperators(num, path + no, target, result, i+1, no, no);
    		} else {
    			    addOperators(num, path + "+" + no, target, result, i+1, eval+no, no);
    				addOperators(num, path + "-" + no, target, result, i+1, eval-no, -no);
    				addOperators(num, path + "*" + no, target, result, i+1, eval-mult + mult*no, mult*no);
    		}
    	}
    }
}