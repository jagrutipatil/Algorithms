/*

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }    
        
        int hits = 0;
        for (int i = 0, k = 0; i < s2.length(); i++) {
            if (--arr[s2.charAt(i) -'a'] >= 0 && ++hits == s1.length()) {
                return true;   
            }                
            if (i >= s1.length()-1 && ++arr[s2.charAt(k++) - 'a'] > 0) {
                hits--;
            }    
        }

        return false;   
    }
}
