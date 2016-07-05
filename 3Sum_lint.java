public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(numbers);
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
        	int j = i + 1;
        	int k = numbers.length - 1;
        	while (j < k) {
        		sum = numbers[i] + numbers[j] + numbers[k];
        		if (sum < 0) {
        			j++;
        		} else if (sum > 0) {
 					k--;
        		} else {
        			ArrayList<Integer> list = new ArrayList<Integer>();
        			list.add(numbers[i]);
        			list.add(numbers[j]);
        			list.add(numbers[k]);
        			set.add(list);
        			j++;
        			k--;
        		}
        	}
        }
        result.addAll(set);
        return result;
    }
}