public class Solution {
    public String countAndSay(int n) {
 		char[] ori = new char[] {'1'};
 		int begin = 0;
 		StringBuffer sb = null;

 		for (int i = 1; i < n; i++) {
 			sb = new StringBuffer();
 			begin = 0;
 			for (int j = 1; j <= ori.length; j++) {
 				if (j == ori.length || ori[j] != ori[j-1]) {
 					sb.append(j-begin);
 					sb.append(ori[j-1]);
 					begin = j;
 				}
 			}
 			ori = sb.toString().toCharArray();
 		}
 		return new String(ori);       
    }
}