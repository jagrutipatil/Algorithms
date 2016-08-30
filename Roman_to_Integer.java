/*
Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Logic: Check current character with next character, if character is less than next character, 
        e.g: IV, minus I then add V = -1+5 = 4
       If no is greather than next character, add the character to result
       e.g: VI, add V, add I = 6 
*/ 


public class Solution {
    public int romanToInt(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int sum = 0, i =0;
    if (s == null) {
    	return 0;
    }

    for (i = 0; i < s.length() -1 ; i++) {
    	if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
    		sum = sum - map.get(s.charAt(i));
    	} else {
    		sum = sum + map.get(s.charAt(i));
    	}
    }
    sum = sum + map.get(s.charAt(i));
    return sum;
    }
}