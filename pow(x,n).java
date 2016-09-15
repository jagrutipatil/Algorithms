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


___________________________________

/********To handle the case where N=INTEGER_MIN we use a long (64-bit) variable. Below is solution:*************/
public class Solution {
    public double myPow(double x, int n) {
		double result = 1.0;
        int sign = 1;
        long nn = n;
        if (n < 0) {
            sign = -1;
            nn = Math.abs((long)n);
        }
            
		while (nn > 0) {
			if (nn%2 != 0) {
				result = result*x;
			}
			x = x*x;
			nn = nn/2;
		}        
		
		if (sign == -1) 
		    return 1/result;
		    
		return result;
    }
}