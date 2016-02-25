public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
 		int totalSum = 0;
 		int total = 0;
 		int remaining = 0;
 		int start = 0;

 		for (int i = 0; i < gas.length; i++) {
 			remaining = gas[i] - cost[i];

 			if (totalSum >= 0) {
 				totalSum += remaining;
 			} else {
 				totalSum = remaining;
 				start = i;
 			}
 			total += remaining;
 		}

 		if (total < 0) {
 			return -1;
 		} 
 			
 		return start;
    }
}