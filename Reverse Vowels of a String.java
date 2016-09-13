/*
	Reverse Vowels of a String

	Write a function that takes a string as input and reverse only the vowels of a string.

	Example 1:
		Given s = "hello", return "holle".

	Example 2:
		Given s = "leetcode", return "leotcede".

	Logic: 1. Traverse from both end till you find vowel, if vowels then reverse it
		   2. characters can be negative, comvert to lower case while comparing to vowel set
Note:
*/
public class Solution {
    public String reverseVowels(String s) {
 		Set<Character> vowels = new HashSet<Character>();
 		vowels.add('a');
 		vowels.add('e');
 		vowels.add('i');
 		vowels.add('o');
 		vowels.add('u');
 		StringBuilder stb = new StringBuilder(s);
 		int i = 0, j = s.length()-1;
 		while (i < j) {
 			while (i < j && !vowels.contains(Character.toLowerCase(s.charAt(i)))) {
 				i++;
 			}
 			while (i < j && !vowels.contains(Character.toLowerCase(s.charAt(j)))) {
 				j--;
 			} 		

 			if (i < j && vowels.contains(Character.toLowerCase(s.charAt(i))) && vowels.contains(Character.toLowerCase(s.charAt(j)))) { 				
 				stb.setCharAt(i, s.charAt(j));
 				stb.setCharAt(j, s.charAt(i));
 				i++;
 				j--;
 			}	
 		}
 		return stb.toString();
    }
}