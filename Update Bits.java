/**
* Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M 
* (e g , M becomes a substring of N located at i and starting at j)
*
* Given N=(10000000000)2, M=(10101)2, i=2, j=6
*
* return N=(10001010100)2
* create a mask leaving i to j bits i.e XXXX(j)0000(i)XXX then perform or operation
*/
class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
    	int ones = ~0;
        int left = ones << (j+1);
        int right = (1 <<i) - 1;
        int mask = 0;
		
		//another solution for negative numbers is to use long for storing masks        
        if (j < 31) {
            mask = left | right;    
        } else {
            mask = ((1 << i) - 1);
        }
        
    	return (n & mask) | (m << i);
    }
}
