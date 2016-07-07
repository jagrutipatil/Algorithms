/*
First Bad Version

The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true

Here we are 100% sure that the 4th version is the first bad version.
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 1, end = n, mid = 0;

        while (start <= end) {
        	mid = (start + end)/2;

        	if (start == end && SVNRepo.isBadVersion(start)) {
        		return start;
        	}
        	
        	if (SVNRepo.isBadVersion(mid)) {
        		end = mid;
        	} else {
        		start = mid + 1;
        	}
        }
        return -1;
    }
}
