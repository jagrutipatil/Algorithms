/*
	Wood Cut

Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
	
	Logic: 
	find max wood, search for cut which will result in max length n will give k pieces

*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int start = 0, end = Integer.MIN_VALUE, mid = 0, maxLen = 0;

        if (L.length == 1) {
        	return L[0]/k;
        }

        for (int no : L) {
        	if (no > end) {
        		end = no;
        	}
        }

        while (start+1 < end) {
        	mid = start + (end - start)/2;
        	int cuts = 0;
        	
		    for (int i = 0; i < L.length; i++) {
        		cuts = cuts + (L[i]/mid);
        	}

        	if (cuts < k) {
        		end = mid ;
        	} else {
        	    maxLen = mid;
        		start = mid;
        	}
        }

        return maxLen;
    }
}