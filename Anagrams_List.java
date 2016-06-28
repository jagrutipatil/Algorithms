public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> result = new ArrayList<String>();

        for (String str : strs) {
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String key = new String(chars);
        	if (!map.containsKey(key)) {
        		map.put(key, new ArrayList<String>());
        	} 
        	map.get(key).add(str);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        	if (entry.getValue().size() > 1) {
        		result.addAll(entry.getValue());
        	}
        }
        return result;
    }
}