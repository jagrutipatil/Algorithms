public class Solution {
    public int compareVersion(String version1, String version2) {
 		String[] s1 = version1.split("\\.");
 		String[] s2 = version2.split("\\.");
 		
 		int l1 = s1.length, l2 = s2.length, n = Math.max(l1, l2);

 		for (int i = 0; i < n; i++) {
 			int v1 = i < l1? Integer.parseInt(s1[i]):0;
 			int v2 = i < l2? Integer.parseInt(s2[i]):0;
 			if (v1 > v2) 
 				return 1;
 			if (v2 > v1)
 				return -1;
 		}

 		return 0;
    }
}