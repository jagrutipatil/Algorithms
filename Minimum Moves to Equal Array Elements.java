/*
    Minimum Moves to Equal Array Elements

    Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

    Example:

    Input:
    [1,2,3]

    Output:
    3

    Explanation:
    Only three moves are needed (remember each move increments two elements):

    [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

public class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, result = 0;
        
        for (int no: nums) {
            min = Math.min(min, no);
        }
        
        for (int no: nums) {
            result += (no - min);
        }
        
        return result;
    }
}