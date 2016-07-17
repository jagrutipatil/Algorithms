/*
Gas Station

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Assumption: cost[i] = 1, means it requires 1 unit of to travel from one station to next station
Analysis

To solve this problem, we need to understand and use the following 2 facts:
1) if the sum of gas >= the sum of cost, then the circle can be completed.
2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.

*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int index = 0, remaining = 0, total = 0, totalRemaining = 0;
    	
    	for (int i = 0; i < gas.length; i++) {
    		remaining = gas[i] - cost[i];
    		if (totalRemaining >= 0) {
    			totalRemaining += remaining;
    		} else {
    			totalRemaining = remaining;
    			index = i;
    		}
    		total += remaining;
    	}

    	if (total >= 0) {
    		return index;
    	}
    	
    	return -1;
    }
}