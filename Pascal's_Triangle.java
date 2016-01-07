public class Solution {
    public List<List<Integer>> generate(int numRows) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();

 		for (int i = 0; i < numRows; i++) {
 			Integer[] row = new Integer[i+1];
 			row[0]=row[i]=1;

 			if (i > 0) {
 				List<Integer> last = result.get(i-1);
 				for (int j = 1; j < i; j++) {
 					row[j] = last.get(j-1) + last.get(j);
 				}
 			}
 			result.add(new ArrayList<Integer>(Arrays.asList(row)));

 		}
 		return result;
    }
}