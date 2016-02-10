public class Solution {
    public int divide(int dividend, int divisor) {
 		int result = 0;
 		int sign = 1;

 		if (divisor == 0)
 			return Integer.MAX_VALUE;
 		if (divisor == -1 && dividend == Integer.MIN_VALUE)
 		    return Integer.MAX_VALUE;

 		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
 			sign = 1;
 		} else {
 			sign = -1;
 		}
 		
 		long divid = Math.abs((long)dividend);
        long divr = Math.abs((long)divisor);
        
 		while (divid >= divr) {
 			int mult = 1;
 			long temp = divr;

 			while (divid >= (temp<<1)) {
 				temp<<=1;
 				mult<<=1;
 			}
 			divid -= temp;
 			result = result + mult;
 		}

 		return sign * result;
    }
}