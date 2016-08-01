/*
Word Ladder II

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
*/

class WordInfo {
	String word;
	int step;
	WordInfo pre;

	public WordInfo(String word, int step, WordInfo pre) {
		this.word = word;
		this.step = step;
		this.pre = pre;
	}	
}

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> result = new ArrayList<List<String>>();
 		Queue<WordInfo> queue = new LinkedList<WordInfo>();
 		HashSet<String> visited = new HashSet<String>();
 		HashSet<String> unvisited = new HashSet<String>();
 		unvisited.addAll(dict);

 		WordInfo sWord = new WordInfo(start, 1, null);
 		queue.add(sWord);

 		int preLevel = 0, minLength = 0, currLevel = 0;

 		while(queue.size() > 0) {
 			WordInfo wordInfo = queue.remove();
 			currLevel = wordInfo.step;

 			if(wordInfo.word.equals(end)) {
 				if (minLength == 0) {
 					minLength = wordInfo.step;
 				}

 				if (minLength == wordInfo.step) {
					List<String> list = new ArrayList<String>();
 					while (wordInfo != null) {
 						list.add(0, wordInfo.word);
 						wordInfo = wordInfo.pre;
 					} 
 					result.add(list);
 				}
 				continue;
 			}

 			if (preLevel < currLevel) {
 				unvisited.removeAll(visited);
 			}

 			preLevel = currLevel;
 			for (int i = 0; i < wordInfo.word.length(); i++) {
 				char t = wordInfo.word.charAt(i);
 				for (char ch = 'a'; ch <= 'z'; ch++) {
 					if (ch != t) {
 						StringBuilder sb = new StringBuilder(wordInfo.word);
 						sb.setCharAt(i, ch);
 						String newWord = sb.toString();
 						if (unvisited.contains(newWord)) {
 							WordInfo nextWord = new WordInfo(newWord, wordInfo.step+1, wordInfo);
 							queue.add(nextWord);
 							visited.add(newWord);	
 						}
 					}
 				}
 			}
 		}
 		return result;
    }
}