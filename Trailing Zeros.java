/**
*
*Write an algorithm which computes the number of trailing zeros in n factorial.*
*
*Example
*11! = 39916800, so the out should be 2
*
*Logic: count number of 5 in factorial, number of 2*5 will give number of trailing zeros generated
*ssNote: there are equal or number of 2 in factorial of any number, and 25 --> 5*5, so need to take into account extra 5 generated also
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long count = 0;

        while (n > 0) {
        	n = n / 5;
        	count += n;
        }
        return count;
    }
};
