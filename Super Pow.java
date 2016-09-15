/*
	Super Pow

	Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024

Logic:

	Math Rule: ab % k = (a%k)(b%k)%k
	Since the power here is an array, we'd better handle it digit by digit.
	
	One observation:
	a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
	
	Simplification:
					Suppose f(a, b) calculates a^b % k; Then translate above formula to using f :
					
					f(a,1234567) = f(a, 1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
*/

public class Solution {
	int base = 1337;
    public int superPow(int a, int[] b) {
        List<Integer> n = new ArrayList<Integer>();
 		for (int no : b) {
 		    n.add(no);
 		}
 		return superPow(a%base, n);
    }

    private int superPow(int a, List<Integer> b) {
        if (b.size() > 0) {
            int lastDigit = b.get(b.size()-1);
    	    b.remove(b.size()-1);
    	    return pow(superPow(a, b), 10) * pow(a, lastDigit) % base;             
        }
        return 1;
    }

    int pow (int x, int n) {
    	long nn = n;
    	int result = 1;
    	while (nn > 0) {
    		if (nn % 2 != 0) {
    			result = result * x;
    			result = result%base;
    		}
    		x = x*x % base;
    		nn = nn/2;
    	}
    	return result % base;
    }
}