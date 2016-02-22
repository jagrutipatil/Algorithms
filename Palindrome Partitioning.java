
//By depth-first search
public class Solution {
    public List<List<String>> partition(String s) {
 		List<List<String>> result = new ArrayList<List<String>>();

 		addPalaindrome(s, result, 0, new ArrayList<String>());
 		return result;
    }

    void addPalaindrome(String s, List<List<String>> result, int start, List<String> temp) {
    	if (start == s.length()) {
    		List<String> list = new ArrayList<String>(temp);
    		result.add(list);
    		return;
    	}

    	for (int i = start+1; i<= s.length(); i++) {
    		String sub = s.substring(start, i);
    		if (isPalaindrome(sub)) {
    			temp.add(sub);
    			addPalaindrome(s, result, i, temp);
    			temp.remove(temp.size()-1);
    		}
    	}
    }

    boolean isPalaindrome(String str) {
    	int i = 0;
    	int j = str.length()-1;

    	while (i < j) {
    		if (str.charAt(i) != str.charAt(j))
    			return false;
    		i++;
    		j--; 
    	}

    	return true;
    }
}


//By Dynmaic programming

public class Solution {
    public List<List<String>> partition(String s) {
 		int[][] dp = new int[s.length()][s.length()];
 		List<List<String>> result = new ArrayList<List<String>>();
 		List<String> temp = new ArrayList<String>();
 		
 		if (s.length() == 1) {
 		    temp.add(s);
 		    result.add(temp);
 		    return result;
 		}
 		
 		for (int l = 1; l <= s.length(); l++ ) {
 			for (int i = 0; i <= s.length()-l; i++) {
 				int j = i + l-1;
 				if (s.charAt(i) == s.charAt(j)) {
 					if (l == 1 || l == 2) {
 						dp[i][j] = 1;
 					} else {
						dp[i][j] = dp[i+1][j-1]; 					
 					}

 					if (dp[i][j] == 1) {
 						temp.add(s.substring(i, j+1));
 					}
 				} else {
 					dp[i][j] = 0;
 				}
 			}
 		}
 		
 		if (temp.size() != 0) {
 			result.add(new ArrayList<String>(temp));
 			temp.clear();
 		}
 		
 		return result;       
    }
}