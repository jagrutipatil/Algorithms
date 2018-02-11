/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      List<Integer> result = new ArrayList<Integer>();
      int hits = 0;
      int[] arr = new int[256];
      for (int i = 0; i < p.length(); i++) {
        arr[p.charAt(i) - 'a']++;
      }       

      for (int i=0, k=0; i < s.length(); i++) {
          if (--arr[s.charAt(i)-'a'] >= 0 && ++hits == p.length()) {
              result.add(k);
          }

          if (i >= p.length()-1 && ++arr[s.charAt(k++)-'a'] > 0) {
            hits--;
          }
      }
      return result;
    }
}
