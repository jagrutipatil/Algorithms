/*
Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

Logic: use string comparator.
*/

class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return (s2+s1).compareTo(s1+s2);
	} 	
}

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        if (num.length == 0) {
        	return "";        	
        }
        String[] strs = new String[num.length];

        for (int i = 0; i < num.length; i++) {
        	strs[i] = num[i] + "";
        }

        Arrays.sort(strs, new StringComparator());

        StringBuilder strb = new StringBuilder();
        for (int i = 0 ; i < num.length; i++) {
        	strb.append(strs[i]);
        }
        
        String largestNo = strb.toString();
        if (largestNo.charAt(0) == '0')
            return "0";
            
        return largestNo;    
    }
}