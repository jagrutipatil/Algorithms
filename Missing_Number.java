
// solution 1, using arithmatic progression, sum of n nnumbers S = ((a_1 + a_n)*n )/2

public class Solution {
    public int missingNumber(int[] nums) {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < nums.length; i++) {
			sum2 +=nums[i];
		} 		       

		//actual sum n = (n+1)/2

		sum1 = ((nums.length * (1+nums.length))/2);
		return sum1 - sum2;
    }
}


//solution 2 XOR
public class Solution {
    public int missingNumber(int[] nums) {
		int result = 0;

		for (int i = 1; i <= nums.length; i++) {
			result ^= nums[i-1] ^ i;
		} 		       

		return result;
    }
}