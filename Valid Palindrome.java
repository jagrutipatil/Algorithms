/*
	Valid Palindrome

	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	Logic: Take two pointers, traverse from start and end, ignore the characters those are not digit or letter, if charcter at start is not equal to character at end, its not palindrome else its palindrome if start and end cross over.
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
 		int start = 0, end = s.length()-1;

 		while (start <= end) {
 			while (start <= end && (!Character.isDigit(s.charAt(start)) || !Character.isLetter(s.charAt(start))))
 				  start++;
 			while (start <= end && (!Character.isDigit(s.charAt(start)) || !Character.isLetter(s.charAt(start))))
 				end--;

 			if (start <= end && (Character.isDigit(s.charAt(start)) && (Character.isDigit(s.charAt(end)) && s.charAt(start) != s.charAt(end)) || (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))))) {
 				return false;
 			} else {
 				start++;
 				end--;
 			}
 		}
 		return true;
    }
}