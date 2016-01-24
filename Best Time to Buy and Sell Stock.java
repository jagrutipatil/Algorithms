public class Solution {
    public int maxProfit(int[] prices) {
 		int[] min = new int[prices.length];
 		int profit = 0, profitMax = 0;
 		for (int i = 0; i < prices.length; i++) {
 			if (i == 0) {
 				min[i] = prices[i];
 			} else {
 				min[i] = Math.min(min[i-1], prices[i]);
 			}
 			profit = prices[i]-min[i];
 			profitMax = profitMax < profit? profit : profitMax; 
 		}       
 		return profitMax;
    }
}