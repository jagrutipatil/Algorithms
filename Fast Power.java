class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        
        if (n == 1 )
            return a % b;
    	if (n == 0) {
    		return 1 % b;
    	}
        long result = fastPower(a, b, n/2);
        result = result * result % b;
        if (n%2 != 0) {
            result = result * a % b;
        }
    	return (int) result;
    }
};