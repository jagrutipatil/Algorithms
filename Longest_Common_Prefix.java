public class Solution {
    public String longestCommonPrefix(String[] strs) {
 		if (strs.length == 0) {
 			return "";
 		}       
 				
 		int i = 0;
 		int length = strs[0].length();
 		for (i = 0; i < length; i++) {
 			char ch = strs[0].charAt(i);
 			boolean allMatch = true;

 			for (String s: strs) {
 				if (s.length() <= i || s.charAt(i) != ch) {
 					allMatch = false;
 					break;
 				}
 			}
 			
 			if (!allMatch) {
 				break;
 			}
 		}
 		return strs[0].substring(0, i);
    }
}