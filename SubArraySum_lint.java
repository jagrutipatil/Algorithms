/**
* Logic: nums[0...a] = k and nums[0..b] = k then nums[a+1...b] = 0
* 
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
        	sum = sum + nums[i];
        	if (map.containsKey(sum)) {
        		result.add(map.get(sum) + 1);
        		result.add(i);
        		return result;
        	}
        	map.put(sum, i);
        }
        return result;
    }
}