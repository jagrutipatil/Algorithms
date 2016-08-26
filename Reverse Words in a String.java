/*
Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
    	if (s == null || s.trim().length() == 0) {
    		return s;
    	}
    	String[] splits = s.trim().split("\\s+");
    	StringBuilder sb = new StringBuilder();
    	for (int i = splits.length-1; i > 0; i--) {
    		sb.append(splits[i]).append(" ");
    	}
    	sb.append(splits[0]);
    	return sb.toString();
    }
}
