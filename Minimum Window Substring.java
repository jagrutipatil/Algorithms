/*
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Complexity: O(n)
Logic: 1. Take tow pointers start and end, get minimum length when end reaches to point having all characters in target.
	   2. Use char[256] to have count of characters.
	  
General Template for substring problems:

int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() {  initialize the hash map here  }

        while(end<s.size()){

            if(map[s[end++]]-- ?){   modify counter here }

            while( counter condition){ 
                 
                  update d here if finding minimum

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ modify counter here }
            }  

            update d here if finding maximum
        }
        return d;
  }	  	

One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to find minimum substring, we should update minimum inside the inner while loop.  
*/
public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
    	int counter = target.length(), d = Integer.MAX_VALUE, head = 0;
    	int begin = 0, end = 0;
    	int[] arr = new int[256];
        
        for (char ch : target.toCharArray()) {
            arr[ch]++;
        }
        
    	while (end < source.length()) {
    		if (arr[source.charAt(end++)]-- > 0)
    			counter--;
    			
    		while (counter == 0) {
    			if ((end - begin) < d) {
    				head = begin;
    				d = end - head;
    			}
    			if (arr[source.charAt(begin++)]++ == 0)
    				counter++;
    		}
    	}
    	return d == Integer.MAX_VALUE? "" : source.substring(head, head + d);
    }
}