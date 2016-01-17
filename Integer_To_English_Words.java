public class Solution {
    public String numberToWords(int num) {
 		if (num == 0)
 			return "Zero";

 		return intToString(num).substring(1);       
    }

    String[] withinTwnty = {"One", "Two", "Three", "Four","Five","Six","Seven","Eight", "Nine","Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen", "Seventeen","Eighteen","Nineteen"};
    
    String[] withinHndrd = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String intToString(int n) {
    	if (n >= 1000000000) return intToString(n/1000000000) + " Billion" + intToString(n - 1000000000*(n/1000000000));
    	else if (n >= 1000000) return intToString(n/1000000) + " Million" + intToString(n - 1000000*(n/1000000)); 
    	else if (n >= 1000) return intToString(n/1000) + " Thousand" + intToString(n - 1000*(n/1000)); 
    	else if (n >= 100) return intToString(n/100) + " Hundred" + intToString(n - 100*(n/100));  
    	else if (n >= 20) return  " " + withinHndrd[(n/10)-2] + intToString(n - 10*(n/10));
    	else if (n >= 1) return " " + withinTwnty[n-1];
    	else return "";
    }
}