class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
    	int count = 0, xor = a ^ b, totalBits = 32;
    	//Total Bits needed as number could be negative number
    	
    	if (xor == 0)
    		return 0;

    	while (totalBits > 0) {
    		count = count + (xor & 1);
    		xor = xor >> 1;
    		totalBits--;
    	}
    	return count;
    }
};
