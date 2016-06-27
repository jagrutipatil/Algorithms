class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
       ArrayList<String> result = new ArrayList<String>();
       int maxLength = Integer.MIN_VALUE;

       for (int i = 0 ;i < dictionary.length; i++) {
       		if (dictionary[i].length() > maxLength) {
       			maxLength = dictionary[i].length();
       			result.clear();
       			result.add(dictionary[i]);
       		} else if (dictionary[i].length() == maxLength) {
       				   result.add(dictionary[i]);
       		}
       }

       return result;
    }
};