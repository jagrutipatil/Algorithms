public class Solution {
	int low = 0, maxlen = 0;
    public String longestPalindrome(String s) {
        
        
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = 0; j <=1 ; j++) {
    			extend(s, i, i+j);
    		}
    	}
    	return s.substring(low, low+maxlen);
    }

    public void extend(String s, int left, int right) {
    	while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}
    	
    	left++;
    	right--;
    	int len = right - left + 1;  // as substring method will exclude right most index
    	if (len > maxlen) {
    		low = left;
    		maxlen = len;
    	}
    }
}