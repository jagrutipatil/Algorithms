/*
	Sqrt(x)

	Implement int sqrt(int x).

	Compute and return the square root of x.

	Logic: Use binary search for finding square root, also keep track of lower boundery each time if number doesn't turn out to be perfect square

*/

public class Solution {
    public int mySqrt(int x) {
 		long start = 1, end = x, ans = 0;
        if (x < 1)
            return 0;
            
 		while (start <= end) {
 			long mid = (start + end)/2;
 			long no = mid*mid;
 			
 			if (no == x) {
 				return (int)mid;
 			} else if (no < x) {
 				start = mid+1;
 				ans = mid;
 			} else {
 				end = mid-1;
 			}
 		} 
 		return (int)ans;      
    }
}