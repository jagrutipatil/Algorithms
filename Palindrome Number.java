/*
	Palindrome Number

	Determine whether an integer is a palindrome. Do this without extra space.

	click to show spoilers.

	Some hints:
				Could negative integers be palindromes? (ie, -1)

	If you are thinking of converting the integer to string, note the restriction of using extra space.

	You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

*/

public class Solution {
    public boolean isPalindrome(int x) {
 		long xx = x;
 		long ori = x;
 		int sign = 1;
 		long yy = 0;

 		if (xx < 0) {
 			sign = -1;     
 			xx = -xx;
 		}
 			
 		while (xx > 0) {
 			int no = (int)xx%10;
 			yy = yy*10 + no;
 			xx = xx/10;
 		}

 		return ori == yy;
    }
}


__________________________________________________________

//Better approach
/*
	Logic: Compare left and right digit in the number,
		   negative number are not Palindrome
*/

public class Solution {
    public boolean isPalindrome(int x) {
        int div = 1;
        if (x < 0)
            return false;
        
        while (x/div >= 10) {
            div = div*10;
        }
        
        while (x != 0) {
            int left = x/div;
            int right = x%10;
            
            if (left != right)
                return false;
            
            x = (x %div)/10 ;
            div = div/100;
        }
        return true;
    }
}