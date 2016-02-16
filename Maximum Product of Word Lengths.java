
//Approach 1 O(n2) 85 sec

public class Solution {
    public int maxProduct(String[] words) {
 		int maxLen = 0, i = 0, j = 0, k = 0;

 		for (i = 0; i < words.length; i++) {
 			String word1 = words[i];
 			int[] arr = new int[26];
 			
 			for (k = 0; k < word1.length(); k++) {
 				arr[word1.charAt(k) - 'a']++;
 			}

 			for (j = i+1; j < words.length; j++) {
 				String word2 = words[j];
 				
 				if (word1.length() * word2.length() <= maxLen)  //pruning necessory
 				    continue;
 				    
 				for (k = 0; k < word2.length(); k++) {
 					if (arr[word2.charAt(k) - 'a'] != 0)
 						break;
 				}

 				if (k == word2.length())
 					maxLen = Math.max(word1.length()*word2.length(), maxLen);
 			}
 		}

 		return maxLen;       
    }
}



//Approach 2 Bit Manupulation

public class Solution {
    public int maxProduct(String[] words) {
		int[] mask = new int[words.length];        
		int maxLen = 0;

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				mask[i] |= 1 << (words[i].charAt(j) - 'a');
			}	
		}

		for (int i = 0; i < mask.length; i++) {
			for (int j = i+1; j < mask.length; j++) {
				if (words[i].length() * words[j].length() <= maxLen)
					continue;

				if ((mask[i]&mask[j]) == 0) {
					maxLen = Math.max(maxLen, words[i].length()*words[j].length());
				}
			}
		}

		return maxLen;
    }
}