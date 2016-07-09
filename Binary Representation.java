/*
	Binary Representation

	Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return ERROR.

	Example
	n = 3.72, return ERROR

	n = 3.5, return 11.1

	Logic:
	1. split the number into integer and fraction part
	2. convert integer to binary form
	3. convert double into binary form
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
    	int decPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
    	double fracPart = Double.parseDouble(n.substring(n.indexOf(".")));
    	String decString = "";
    	String fracString = "";
        
        if (decPart == 0)
            decString = "0";
    	while (decPart > 0) {
    		decString =  decPart % 2 + decString;
    		decPart = decPart >> 1;
    	}

    	while (fracPart > 0.0) {
    		if (fracString.length() > 32) 
    			return "ERROR";
    		fracPart = fracPart * 2;
    		if (fracPart >= 1) {
    			fracString += "1";
    			fracPart -= 1;
    		} else {
    			fracString += "0";
    		}
    	}

    	return fracString.length() > 0? decString + "." + fracString : decString;
    }
}