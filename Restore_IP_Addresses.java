public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
 		List<String> result = new ArrayList<String>();
 		
        if (s == null)
            return result;

 		for (int i = 1; i <=3 ; i++) {
 			if (len-i > 9) 
 				continue;
 			for (int j = i+1; j <=i+3; j++) {
 				if (len-j > 6)
 					continue;

 				for (int k = j+1; k <= j+3 && k<len; k++) {
 				    String s1 = s.substring(0, i);
 				    String s2 = s.substring(i, j);
 				    String s3 = s.substring(j, k);
 				    String s4 = s.substring(k);
 				    
 					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
 					    result.add(s1 + "." + s2 + "." + s3 + "." + s4);    
 					}
 				}	 
 			}		
 		}
 		
 		return result;
    }
    
    boolean isValid(String s) {
        if ( s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}