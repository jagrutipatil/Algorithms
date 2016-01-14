/*
1. remove the trailing whitespaces, 
2. get the -ve/+ve
3. Handle overflow and invalid input
4. return the result

*/


public class Solution {
    public int myAtoi(String str) {
 		int i = 0, indicator = 1;
        long result = 0;
        
 		if (str == null)
 			return 0;
 			
 		for (; i < str.length() && str.charAt(i) == ' ' ; i++);

 		if (i < str.length() && str.charAt(i) == '-') {
 			indicator = -1;
 			i++;
 		} else if (i < str.length() && str.charAt(i) == '+') {
 			i++;
 		}

 		for (; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
 			result = result*10 + (str.charAt(i) - '0');
 			if ( indicator > 0 && result > Integer.MAX_VALUE) 
 			    return Integer.MAX_VALUE;
 			    
 		    if ( indicator < 0 && -result < Integer.MIN_VALUE) 
 			    return Integer.MIN_VALUE;
  		}
        
        
        result = result*indicator;
 		return (int)result;
    }
}