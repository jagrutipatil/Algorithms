/* 
	Longest Substring Without Repeating Characters
	Given a string, find the length of the longest substring without repeating characters.

	For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

	For "bbbbb" the longest substring is "b", with the length of 1.
	
	Logic: Time complexity O(n) solution: use array of 256 characters initialized with -1, if character has never occured before or occurred before current starting index of new substring
			then increment the current length else take max of currentlength with previous max length.

*/
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


//____________________________________________________________________

With O(n) space
public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
    	int len = 0, max = 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();

    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (map.containsKey(ch)) {
    			int lastIndex = map.get(ch);
    			removeBefore(ch, map);
    			len = i - lastIndex;
    			map.put(ch, i);
    		} else {
    			map.put(ch, i);
    			len++;
    		}
    		max = Math.max(max, len);
    	}
    	return max;
    }

    private void removeBefore(Character ch, Map<Character, Integer> map) {
    	int index = map.get(ch);
    	Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>)it.next();
            if (entry.getValue() <= index)            
                it.remove(); 
        }
    }
}



____________________________________________________________________________________________

//Another efficient solution
/* Template for all substring problems

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
    public int lengthOfLongestSubstring(String s) {
        int begin = 0, end = 0;
        int count = 0, len = 0;
        int[] map = new int[256];

        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 1)
                count++;
            while (count != 0) {
                if (map[s.charAt(begin++)]-- == 2)
                    count--;
            }
            len = Math.max(len, end - begin);
        }

        return Math.max(len, end - begin);
    }
}