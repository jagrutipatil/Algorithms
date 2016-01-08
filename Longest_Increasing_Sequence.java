public class Solution {
    public int lengthOfLIS(int[] nums) {
 		int[] dp = new int[nums.length];       
 		int len = 0, i = 0;

 		for (int no : nums) {
 			i = Arrays.binarySearch(dp, 0, len, no);
 			if (i < 0) i = - (i +1);
 			dp[i] = no;

 			if (i == len) len++;
 		}
 		return len;
    }
}