public class Solution {
    public int climbStairs(int n) {
 		if (n == 0)
 			return 0;
		if (n == 1)  			       
			return 1;
		int a1 = 1;
		int a2 = 1;

		for (int i = 2; i <= n; i++) {
			int a = a1+a2;
			a1 = a2;
			a2 = a;
		}

		return a2;
    }
}