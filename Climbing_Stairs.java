/*
Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3

Logic: This is Dynamic programming problem. for any step n, all unique combination to reach n are unique_combination(n-1) + unique_combination(n-2)
	         
*/

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