/*
    Combination Sum III
    
    Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


    Example 1:

    Input: k = 3, n = 7

    Output:

    [[1,2,4]]
    
    Example 2:

    Input: k = 3, n = 9

    Output:

    [[1,2,6], [1,3,5], [2,3,4]]

*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		combination(result, new ArrayList<Integer>(), k, 1, n);       
 		return result;
    }

    void combination(List<List<Integer>> result, List<Integer> temp, int k, int start, int n) {
    	if (temp.size() == k && n == 0) {
    		List<Integer> list = new ArrayList<Integer>(temp);
    		result.add(list);
    		return;
    	}

    	for (int i = start; i <= 9; i++) {
    		temp.add(i);
    		combination(result, temp, k, i+1, n-i);
    		temp.remove(temp.size()-1);
    	}
    }
}


___________________________________________
//Small optimation if partial sum is less than target then and then only iterate through remaining integers

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum3(k, n, 0, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void combinationSum3(int k, int n, int sum, int start, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }

        for (int i = start; i <= 9 && sum + i <= n; i++) {
            list.add(i);
            combinationSum3(k, n, sum+i, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}