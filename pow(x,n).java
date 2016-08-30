/*
Pow(x, n)
implement pow(x, n).

Logic: Main logic here is to divide the power and multiply the number to itself and keep building result.
	   Two main test cases here if power is here or power is odd, if power is odd then you want to multiply that number only once and if even then twice.
*/


//Brute Force Solution

public class Solution {
    public double myPow(double x, int n) {
 		double mult = 1;
 		for (int i = 1; i <= n; i++) {
 			mult = mult * x;
 		}  
 		return mult;     
    }
}

//more effective sollution

public class Solution {
    public double myPow(double x, int n) {
 		double result = 1;
 		int nn = n;

 		if (n < 0) {
 			nn = -n;
 		}

 		while (nn > 0) {
 			if (nn %2 != 0) {
 				result = result * x;
 			}
 			x =x *x;
 			nn = nn/2;
 		}
 		
 		if (n < 0) {
 			return 1/result;
 		}

 		return result;
    }
}