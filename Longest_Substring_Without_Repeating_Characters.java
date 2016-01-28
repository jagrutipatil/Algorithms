// Longest Substring Without Repeating Characters


public class Solution {
    public int lengthOfLongestSubstring(String s) {
 		if (s == null || s.equals(""))
 		    return 0;
 		
 		int[] found = new int[256];
 		int currLength = 0, prevIndex = 0, maxLength = 0, i = 0;
        
 		for (i = 0; i < 256; i++)
 			found[i] = -1;
        
 		for (i = 0; i < s.length(); i++) {
 			prevIndex = found[s.charAt(i)];
 			if (prevIndex == -1 || i-currLength > prevIndex) {
 				currLength++;
 			} else {
 				if (maxLength < currLength)
 					maxLength = currLength;
 				currLength = i - prevIndex;
 			}
 			found[s.charAt(i)] =i;
 		}   
 		    
 		if (currLength > maxLength)
 			maxLength = currLength;

 		return maxLength;
    }
}
