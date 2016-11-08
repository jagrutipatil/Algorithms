/*
	Longest Substring Without Repeating Characters

	Given a string, find the length of the longest substring without repeating characters.

	Examples:

	Given "abcabcbb", the answer is "abc", which the length is 3.

	Given "bbbbb", the answer is "b", with the length of 1.

	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
 		int arr[] = new int[256];
 		int begin = 0, end = 0, c = 0, maxLen = 0, fBegin = 0;

 		while (end < s.length()) {
 			if (++arr[s.charAt(end++)] > 1) {
 				c++;
 			}

 			while (c > 0) {
 				if (arr[s.charAt(begin++)]-- > 1) {
 					c--;
 				}
 			}
 			int len = end - begin;
 			if (len > maxLen) {
 				fBegin = begin;
 				maxLen = len;
 			}
 		}
 		return maxLen;
    }
}