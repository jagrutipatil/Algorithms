class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        } 
        return (n & (n-1)) == 0;
    }
};