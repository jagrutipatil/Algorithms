/*
	Ransom Note

	Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

	Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

	Note:
	You may assume that both strings contain only lowercase letters.

	canConstruct("a", "b") -> false
	canConstruct("aa", "ab") -> false
	canConstruct("aa", "aab") -> true

	Logic: Take count of each character in magazine, if the character count is less than magazine then return false else true.
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
 		int[] arr = new int[26];
 		for (char ch: magazine.toCharArray()) {
 			arr[ch-'a']++;
 		}       

 		for (char ch: ransomNote.toCharArray()) {
 			if (--arr[ch-'a'] < 0) {
 				return false;
 			}
 		}
 		return true;
    }
}