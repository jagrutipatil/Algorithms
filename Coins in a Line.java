/*
	Coins in a Line

	There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

	Could you please decide the first player will win or lose?

	Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

Note: First Palyer tries to win at its best, 2nd player also tries to win at its best, so winning 1st player by comparmising 2nd to lose can not be counted as win for first player.

Logic: 
n = 1 true,  first player can pick one coin so it wins
n = 2 true,  first player can pick two coins so it wins
n = 3 false, 
			if first player picks one coin, so another player will pick two coins as it is also trying to win, so first player lose.
	   	    if first player picks two coins, another player will pick one coin so first player lose	 

n = 4, first player choose 1, 2nd player choose 1/2 last coin will be for player 1 hence first player wins
n = 5, first player choose 2, 2nd player choose 1/2 last coing will be for player 1 hence first player wins

n = 6, first player choose 1, 2nd player choose 2, 1st player choose 1/2, last coin will be for 2nd player, 1st player loose
       first player choose 2, 2nd player choose 1, 1st player choose 1/2, 2nd player will win

From observation we can see that first player will only loose if total number are coins are divisible by 3

*/

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        return n % 3 != 0;
    }
}