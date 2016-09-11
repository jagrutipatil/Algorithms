/*
    Search in Rotated Sorted Array

    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.

    Logic:
        Use Binary Search, if half of the array is in order and target lies in that half - search in the half array else in another half
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        int start = 0, end = A.length -1 , mid = 0;

        while (start <= end) {
            mid = (start + end)/2;

            if (A[mid] == target) {
                return mid;
            } 

            if (A[start] <= A[mid]) {
                if (A[start] <= target && target < A[mid]) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (  A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
