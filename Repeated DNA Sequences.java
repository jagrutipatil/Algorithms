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