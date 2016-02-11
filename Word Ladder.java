public class Solution {
	
	class Word{
		String word;
		int step;

		Word(String word, int step) {
			this.word = word;
			this.step = step;
		}
	}

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
 		Queue<Word> queue = new LinkedList<Word>();
 		queue.add(new Word(beginWord, 1));
 		wordList.add(endWord);

 		while (queue.size() > 0) {
 			Word word = queue.remove();

 			if (word.word.equals(endWord))
 				return word.step;

 			char[] charArray = word.word.toCharArray();

 			for (int i = 0; i < charArray.length; i++) {
 				char t = charArray[i];
 				for (char c = 'a'; c <='z'; c++) {
 					if (c != t) {
 						charArray[i] = c;
 					} 						 				

 					String temp = new String(charArray);
 					if (wordList.contains(temp)) {
 						queue.add(new Word(temp, word.step+1));		
 						wordList.remove(temp);
 					}
 					charArray[i] = t;
 				}
 			}
 		}

 		return 0;
    }
}