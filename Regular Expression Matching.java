public class Solution {
    
	boolean matchFirst(String s, String p, int i, int j) {
		return (i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)) || ( j < p.length() && p.charAt(j) == '.' && s.length() > i);
	}

    public boolean isMatch(String s, String p) {
 		       return regExMatch(s, p, 0, 0);
    }

    boolean regExMatch(String s, String p, int i, int j) {
    	if (j >= p.length())
 			return s.length() <= i;

 		if (j+1 >= p.length()) {
 			if (!matchFirst(s, p, i, j))
 				return false;
 				return regExMatch(s, p, i+1, j+1);
 		} else if (j+1 < p.length() && p.charAt(j+1) != '*') {
	 			if (!matchFirst(s, p, i, j))
	 				return false;
 			return regExMatch(s, p, i+1, j+1);	
 		} else {
 			if (regExMatch(s, p, i, j+2))
 				return true;
 			while (matchFirst(s, p, i, j)) {
 				i++;
 				if (regExMatch(s, p, i, j+2))
 					return true; 
 			}
 		}
 		
 		return false;
    }
}