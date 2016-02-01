public class Solution {
    public List<String> letterCombinations(String digits) {
    	String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
 		List<String> result = new ArrayList<String>();
 		StringBuffer sb = new StringBuffer("");
        if (digits == null || digits.equals(""))
            return result;
            
 		permutation(digits, 0, sb, result, letters);
 		return result;
    }

    void permutation(String digits, int number, StringBuffer sb, List<String> result, String[] letters) {
    	if (digits.length() == number) {
    		result.add(sb.toString());
    		return;
    	}

    	String temp = letters[digits.charAt(number) - '2'];
    	for (int i = 0; i < temp.length(); i++) {
    		sb.append(temp.charAt(i));
    		permutation(digits, number+1, sb, result, letters);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
}