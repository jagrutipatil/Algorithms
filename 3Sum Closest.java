public class Solution {
    public int threeSumClosest(int[] nums, int target) {
 		Arrays.sort(nums);       
 		int minDiff = Integer.MAX_VALUE;
 		int result = 0;
 		int j = 0, k = 0;

 		for (int i = 0; i < nums.length; i++) {
 			j = i+1;
 			k = nums.length -1;

 			while (j < k) {
 				int sum = nums[i] + nums[j] + nums[k];
 				int currDiff = Math.abs(sum - target);

 				if (sum == target ) 
 					return sum;

 				if (currDiff < minDiff ) {
 					result = sum;
 					minDiff = currDiff;
 				}

 				if (sum < target) {
 					j++;
 				} else {
 					k--;
 				}
 			}
 		}

 		return result;
    }
}