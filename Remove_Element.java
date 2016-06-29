/**
*Remove Element
*
*Given an array and a value, remove all occurrences of that value in place and return the new length.
*The order of elements can be changed, and the elements after the new length don't matter.
*
*e.g: Given an array [0,4,4,0,0,2,4,4], value=4
*     return 4 and front four elements of the array is [0,0,0,2]
*/
public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int i = 0, j = 0;

        while (j < A.length) {
        	while (j < A.length && A[j] == elem) {
        		j++;        		
        	}
        	if (j < A.length){
        	   A[i] = A[j];
        	   i++;
        	}
        	j++;   
        }

        return i;
    }
}
