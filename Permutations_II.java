public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
  		Arrays.sort(nums);       
  		do {
  			List<Integer> list = new ArrayList<Integer>();

  			for (int i = 0; i < nums.length; i++) {
  				list.add(nums[i]);
  			}
  			result.add(list);
  		} while(nextPermutation(nums));
  		return result;
    }

    boolean nextPermutation(int[] nums) {
    	int n = nums.length, desc = 0;

    	for (int i = n-1; i > 0; i--) {
    		if (nums[i] > nums[i-1]) {
    			desc = i;
    			break;
    		}
    	}

    	if (desc == 0) 
    		return false;
    	
    	for (int i = n-1; i >= desc ; i--) {
    		if (nums[i] > nums[desc -1]) {
    			swap(nums, i, desc-1);
    			break;
    		}
    	}
    	reverse(nums, desc, n-1);
    	return truel
    }

    void swap(int[] nums, int i, int j) {
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
    }

    void reverse(int[] nums, int i, int j) {
    	for (; i < j; i++, j--) {
    		swap(nums, i, j);
    	}
    }
}