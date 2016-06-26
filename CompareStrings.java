public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] frequencyA = new int[255];

        if (A == null || B == null || B.length() > A.length())
        	return false;

        if (B.length() == 0)
        	return true;

        for (int i = 0; i < A.length(); i++) {
        	frequencyA[A.charAt(i)]++;
        }	

        for (int i = 0; i < B.length(); i++) {
        	if (--frequencyA[B.charAt(i)] < 0) {
        		return false;
        	}
        }
        return true;
    }
}