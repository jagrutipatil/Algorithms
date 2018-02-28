/*
Repeated String Match

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int j = 0;
        for (int i = 0; i < A.length(); i++) {
            for (j = 0; j < B.length() && A.charAt((i+j) % A.length()) == B.charAt(j); j++);
            if (j == B.length())
                return ((i+j) / A.length()) + ((i+j)%A.length() != 0? 1 : 0);
        }
        return -1;
    }
}

// alternate
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder stb = new StringBuilder();
        while (stb.length() < B.length()) {
            stb.append(A);
            count++;
        }
        
        if (stb.toString().contains(B))
            return count;
        
        if (stb.append(A).toString().contains(B))
            return count + 1;
        return -1;
    }
}
