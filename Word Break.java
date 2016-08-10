/*
Word Break

Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code"

*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
 		int n = s.length();
 		boolean[] dp = new boolean[n+1];
 		dp[0] = true;

 		for (int i = 0; i < n; i++) {
 			if (!dp[i])
 				continue;

 			for (String word : wordDict) {
 				int len = word.length();
 				int end = i + len;

 				if (end > n)
 					continue;

 				if (s.substring(i, end).equals(word)) {
 					dp[end] = true;
 				} 
 			}
 		}
 		return dp[n];       
    }
}