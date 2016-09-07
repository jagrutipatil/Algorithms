/*
	Repeated DNA Sequences
	
	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

	Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

	For example,

	Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

	Return:
		["AAAAACCCCC", "CCCCCAAAAA"].
*/


public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
 		Set<String> result = new HashSet<String>();
 		Set<String> visited = new HashSet<String>();

 		for (int i = 0; i+9 < s.length(); i++) {
 			String sub = s.substring(i, i+10);
 			if (!visited.add(sub)) {
 				result.add(sub);
 			}
 		}
 		return new ArrayList(result);
    }
}


_____________________________________________________

//bitwise efficient Solution
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	Set<Integer> first = new HashSet<Integer>();
    	Set<Integer> second = new HashSet<Integer>();
    	List<String> result = new ArrayList<String>();
    	char[] chars = new char[26];

    	chars['A' - 'A'] = 0;
    	chars['C' - 'A'] = 1;
    	chars['G' - 'A'] = 2;
    	chars['T' - 'A'] = 3;

 		for (int i = 0; i <= s.length() - 10; i++) {
 			int bitChar = 0;
 			for (int j = i; j < i + 10; j++) {
 				bitChar = bitChar << 2;
 				bitChar = bitChar | chars[s.charAt(j) - 'A'];
 			}

 			if (!first.add(bitChar) && second.add(bitChar))
 				result.add(s.substring(i, i+10));
 		}
 		return result;       
    }
}

