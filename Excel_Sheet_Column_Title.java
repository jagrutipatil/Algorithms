public class Solution {
    public String convertToTitle(int n) {
 		StringBuilder sb = new StringBuilder();
 		while (n != 0) {
 			n--;
 			char ch = (char)('A' + n%26);
 			sb.append(ch);
 			n = n/ 26;
 		}	
 		sb.reverse();
 		return sb.toString(); 
    }
}