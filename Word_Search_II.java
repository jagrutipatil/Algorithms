public class Solution {
	Set<String> result = new HashSet<String>();    
    
    public List<String> findWords(char[][] board, String[] words) {
 	    Trie trie = new Trie();	
 		for (String word: words) {
 			trie.insert(word);
 		}		       

 		int m = board.length;
 		int n = board[0].length;
 		boolean[][] visited = new boolean[m][n];
 		for (int i = 0; i < m; i++) {
 			for (int j = 0; j < n; j++) {
 				dfs(board, visited, i, j, "", trie);
 			}
 		}
 		
 		return new ArrayList<String>(result);
    }

    void dfs(char[][] board, boolean[][] visited, int i, int j, String str, Trie trie) {
    	int m = board.length-1;
    	int n = board[0].length-1;

    	if (i < 0 || j < 0 || i > m || j > n)	
    		return;

    	if (visited[i][j])	
    		return;

    	str += board[i][j];
    	
    	if (!trie.startsWith(str))	
    		return;

    	if (trie.search(str)) 
    		result.add(str);

    	visited[i][j] = true;
    	dfs(board, visited, i, j+1, str, trie);
    	dfs(board, visited, i, j-1, str, trie);
    	dfs(board, visited, i+1, j, str, trie);
    	dfs(board, visited, i-1, j, str, trie);
    	visited[i][j] = false;    	
    }
}

class TrieNode {
        TrieNode[] branch;
        boolean isWord;
        // Initialize your data structure here.
        public TrieNode() {
             branch = new TrieNode[26];
        }
}

class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a'] == null) cur.branch[c-'a'] = new TrieNode();
                cur = cur.branch[c-'a'];
            }
            cur.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a'] == null) return false;
                cur = cur.branch[c-'a'];
            }
            return cur.isWord == true;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.branch[c-'a'] == null) return false;
                cur = cur.branch[c-'a'];
            }
            return true;
        }
    }