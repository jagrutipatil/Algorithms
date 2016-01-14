public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
            
 		String[] words = s.trim().split(" ");       
 		if (words.length == 0) {
 			return s;
 		}

 		StringBuffer sb = new StringBuffer();

 		for (int i = words.length - 1; i >= 0; i--) {
 		    if (!words[i].equals("")) {
 		        sb.append(words[i]).append(" ");    
 		    }	
 		}
 		
 		return sb.length() == 0? "" : sb.substring(0, sb.length()-1);
    }
}