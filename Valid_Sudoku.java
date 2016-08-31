/*
Determine whether a Sudoku is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character ..


Logic:
	1. Take 3 sets, one for row, one for colum and one for grid validation.
		if number is duplicated in the set then its not a valid sudoku
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
 		Set<Character> set1 = new HashSet<Character>();
 		Set<Character> set2 = new HashSet<Character>();
 		Set<Character> set3 = new HashSet<Character>();

 		for (int i = 0; i < 9; i++) {
 			set1.clear();
 			set2.clear();
 			set3.clear();
 			for (int j = 0; j < 9; j++) {
 				Character ch = board[i][j];
 				if (Character.isDigit(ch)) {
 					if (!set1.contains(ch)) {
 						set1.add(ch);
 					} else {
 						return false;
 					}
 				}

 				ch = board[j][i];
 				if (Character.isDigit(ch)) {
 					if (!set2.contains(ch)) {
 						set2.add(ch);
 					} else {
 						return false;
 					}
 				}

 				int x = i/3*3+ j/3;
 				int y = i%3*3 + j%3;
 				ch = board[x][y];
 				if (Character.isDigit(ch)) {
 					if (!set3.contains(ch)) {
 						set3.add(ch);
 					} else {
 						return false;
 					}
 				}
 			}
 		}
 		return true;
    }
}