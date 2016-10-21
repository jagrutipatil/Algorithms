/*
	Longest Palindrome

	Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

	This is case sensitive, for example "Aa" is not considered a palindrome here.

	Logic: total length = total even occurences + 1 (if any odd occurence)
*/

public class Solution {
    public int longestPalindrome(String s) {
 		Map<Character, Integer> map = new HashMap<Character, Integer>();

 		for (char ch : s.toCharArray()) {
 			if (map.containsKey(ch)) {
 				map.put(ch, map.get(ch)+1);
 			} else {
 				map.put(ch, 1);
 			}
 		}

 		int totalLength = 0;
 		boolean isOdd = false;
 		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
 			if (entry.getValue()%2 == 0) {
 				totalLength += entry.getValue();
 			} else if (entry.getValue() == 1) {
 				isOdd = true;
 			} else {
 				if (entry.getValue()/2 != 0)
 					isOdd = true;
 				totalLength += (entry.getValue()/2)*2;
 			}
 		}

 		if (isOdd) {
 			totalLength += 1;
 		}

 		return totalLength;
    }
}