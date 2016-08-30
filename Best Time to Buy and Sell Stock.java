/*
Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.

Logic: Find out minimum stock price everytime, and calculate max profit depending on current minimum stock price.
*/

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


_________________________________________________________________

//More cleaner way, only time complexity O(n), no space complexity 

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;

        for (int price : prices) {
        	if (price < min) {
        		min = price;
        	}

        	profit = Math.max(profit, price - min);
        }
        return profit;
    }
}