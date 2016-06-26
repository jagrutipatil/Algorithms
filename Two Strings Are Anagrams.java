/**
*  Write a method anagram(s,t) to decide if two strings are anagrams or not.
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        int[] chars = new int[255];
        int i = 0;

        if (s.length() != t.length())
        	return false;

        for (i = 0; i < s.length(); i++) {
        	chars[s.charAt(i)]++;
        }

        for (i = 0; i < t.length(); i++) {
        	chars[t.charAt(i)]--;
        }

        for (i = 0; i < 255 ; i++) {
        	if (chars[i] != 0)
        		return false;
        }
        return true;
    }
};