/*
	Word Search

	Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

	Example
Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.

	Logic: for each chracter search next character around it recursively.
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (search(board, word, i, j, 0))
    				return true;
    		}    		
    	}

    	return false;
    }

    boolean search(char[][] board, String word, int i, int j, int index) {
    	if (i < 0 || j < 0 || j >= board[0].length ||  i >= board.length|| index > word.length() || board[i][j] != word.charAt(index))
    		return false;

    	if (index == word.length()-1)
    		return true;
    		
    	char ch = board[i][j];
    	board[i][j] = '#';
    	boolean found = search(board, word, i+1, j, index+1) || search(board, word, i-1, j, index+1) || search(board, word, i, j+1, index+1) || search(board, word, i, j-1, index+1);
    	board[i][j] = ch;
    	
    	return found;
    }
}