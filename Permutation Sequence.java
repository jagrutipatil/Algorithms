// Explaination http://yucoding.blogspot.com/2013/04/leetcode-question-68-permutation.html

public class Solution {
    public String getPermutation(int n, int k) {
 		int i = 0, index = 0;
 		int mod = 1;
 		List<Integer> list = new ArrayList<Integer>();
 		StringBuffer result = new StringBuffer("");

 		for (i = 1; i <= n ;i++) {
 			mod = mod * i;
 			list.add(i);
 		}

 		k--;
 		for (i = 0; i < n; i++) {
 			mod = mod / (n-i);
 			index = k/mod;
 			k = k % mod;

 			result.append( list.get(index) + "");
 			list.remove(index);
 		}

 		return result.toString();
    }
}