/*
Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Example
Given s = "Hello World", return 5.
*/
public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
    	int end = 0, count = 0;
    	s = s.trim();
    	for (end = s.length()-1; end >= 0 && s.charAt(end) != ' '; end--) {
    		count++;
    	}
    	return count;
    }
}