/**
* For a given source string and a target string, you should output the first index(from 0) of target string in source string.
* If target does not exist in source, just return -1.
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        int i = 0, j = 0, start = 0;

        
        if (source == null || target == null || target.length() > source.length()) { 
            return -1;
        }

        if (source.length() == 0 && target.length() == 0 || target.length() == 0) {
            return 0;
        }

        for (i = 0; i < source.length(); i++) {
            start = i;
            j = 0;
            if (source.charAt(i) == target.charAt(j)) {
                while (i < source.length() && j < target.length() && source.charAt(i) == target.charAt(j)) {
                    j++;
                    i++;
                }
                if (j == target.length())
                    return start;
            }
            i = start; 
        }

        return -1;
    }
}


//Clean Version

public class Solution {
    public int strStr(String haystack, String needle) {                
    	for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) 
                    return i;
                
                if (i+j == haystack.length()) 
                    return -1;
                
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
        }
    }
}
