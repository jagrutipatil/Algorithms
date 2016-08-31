/*
    Longest Palindromic Substring

    Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

    Example
    Given the string = "abcdzdcab", return "cdzdc".

    Logic: string is palindrome if its reverse is the same string, i.e around a center approaching towards its left and right, all characters are same
           e.g: aba. You can loop over a string and considering each index as a center and find out its left and right, store string's start and length to return the largest palindrome substring.
           - consider even and odd length palindrome substrings


*/
public class Solution {
	int low = 0, maxlen = 0;
    public String longestPalindrome(String s) {
        
        
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = 0; j <=1 ; j++) {
    			extend(s, i, i+j);
    		}
    	}
    	return s.substring(low, low+maxlen);
    }

    public void extend(String s, int left, int right) {
    	while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}
    	
    	left++;
    	right--;
    	int len = right - left + 1;  // as substring method will exclude right most index
    	if (len > maxlen) {
    		low = left;
    		maxlen = len;
    	}
    }
}