/*
	Find the Difference

	Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.


Logic:
     1. iterate through s and keep count of each character in map
     2. iterate through t and find out which character is missing or whose frequency is zero, if character is present in map then decrement its frequency
*/

public class Solution {
    public char findTheDifference(String s, String t) {
 		Map<Character, Integer> map = new HashMap<Character, Integer>();

 		for (Character ch : s.toCharArray()) {
 			if (map.containsKey(ch)) {
 				map.put(ch, map.get(ch) + 1);
 			} else {
 				map.put(ch, 1);
 			}
 		}     

 		for (Character ch : t.toCharArray()) {
 			if (map.get(ch) == null || map.get(ch) == 0) {
 				return ch;
 			} else {
 			    map.put(ch, map.get(ch)-1);
 			}
 		}  
 		return ' ';
    }
}