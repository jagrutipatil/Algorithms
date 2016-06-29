public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
 		StringBuilder prefix = new StringBuilder();
 		
 		if (strs.length == 0) {
 			return "";
 		}
 			
 		if (strs.length < 2) {
 			return strs[0];
 		}
        
        int j = 1;
 		for (int i = 0; i < strs[0].length(); i++) {
 			for (j = 1; j < strs.length; j++) {
 				 if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
 				 	break;
 				 } 
 			}
 			if (j >= strs.length) {
 			    prefix.append(strs[0].charAt(i));
 			} else {
 				break;
 			}
 		}

 		return prefix.toString();
    }
}