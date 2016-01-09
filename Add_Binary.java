public class Solution {
    public String addBinary(String a, String b) {
 		int m = a.length();
 		int n = b.length();
 		int carry = 0;
 		int max = Math.max(m, n);       
 		String result = "";

 		for (int i = 0; i < max; i++) {
 			int p = i < m ? a.charAt(m - 1- i) - '0' : 0;
 			int q = i < n ? b.charAt(n - 1- i) - '0' : 0;
 			int temp = p + q + carry;
 			carry = temp/2;
 			result = temp%2 + result;
 		}

 		return carry == 0? result : "1" + result; 
    }
}