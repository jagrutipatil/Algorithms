/*
Word Search II

Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 

Given matrix:
doaf
agai
dcan

and dictionary:
{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}

Logic: Use Trie
*/

class TrieNode {
    Map<Character, TrieNode> map;
    boolean isEndOfWord;
    String word;

    TrieNode() {
        map = new HashMap<Character, TrieNode>();
        isEndOfWord = false;
        word = null;
    }    
}

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        TrieNode root = new TrieNode();
        ArrayList<String> result = new ArrayList<String>();
        buildTrie(root, words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(board, root, i, j, result);
            }
        }
        return result;
    }

    void buildTrie(TrieNode root, List<String> words) {
        TrieNode node = null;
        for (String word : words) {
            node = root;
            for (char ch: word.toCharArray()) {
                if (node.map.get(ch) == null) {
                    TrieNode p = new TrieNode();
                    node.map.put(ch, p);
                }
                node = node.map.get(ch);
            }
            node.isEndOfWord = true;
            node.word = word;
        }
    }

    void findWord(char[][] board, TrieNode node, int i, int j, List<String> result) {
        char ch = board[i][j];
        node = node.map.get(ch);
        
        if (ch == '#' || node == null)
            return;
        
        if (node.isEndOfWord && node.word != null) {
            result.add(node.word);  
            node.word = null;
        } 

        board[i][j] = '#';
        if (i > 0) findWord(board, node, i-1, j, result);   
        if (j > 0) findWord(board, node, i, j-1, result);   
        if (i < (board.length-1)) findWord(board, node, i + 1, j, result);   
        if (j < (board[0].length-1)) findWord(board, node, i, j+1, result);   
        board[i][j] = ch;
    }
}