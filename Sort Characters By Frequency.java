/*
	Sort Characters By Frequency

	Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.



Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


Logic: 
   1. find out frequency of each character
   2. store frequency vs character in an array length of string length
   3. traverse the array from end i.e from most frequent character and form new string by appending those characters
   
*/

public class Solution {
    public String frequencySort(String s) {
 		Map<Character, Integer> map = new HashMap<Character, Integer>();

 		for (Character ch : s.toCharArray()) {
 			if (map.containsKey(ch)) {
 				map.put(ch, map.get(ch)+1);
 			} else {
 				map.put(ch, 1);
 			}
 		}

 		List<List<Character>> list = new ArrayList<List<Character>>();
 		for (int i = 0; i < s.length(); i++) {
 			list.add(new ArrayList<Character>());
 		}

 		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
 			List<Character> temp = list.get(entry.getValue());
 			temp.add(entry.getKey());
 		}

 		StringBuffer stb = new StringBuffer();
 		for (int i = s.length()-1; i >= 0; i--) {
 			if (list.get(i).size() != 0) {
 			    for (Character ch : list.get(i)) {
 			        for (int k = 0; k < map.get(ch); k++) {
 			            stb.append(ch + "");        
 			        }
 			    }
 			}
 		}
 		return stb.toString();
    }
}