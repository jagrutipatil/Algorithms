public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>(); 		
 		Arrays.sort(nums);
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        
 		for (int i = nums.length-1; i >= 0; i--) {
 		    int no = nums[i];
 			
 			
 			if (i == nums.length-1 || nums[i] != nums[i+1] || temp.size() == 0) {
 			    temp = new ArrayList<List<Integer>>();
 				for (List<Integer> list : result) {
 			    	temp.add(new ArrayList<Integer>(list));
 				}
 			}
 			
 			for (List<Integer> list : temp) {
 				    list.add(0, no);
 			}
 			
            
            if (i == nums.length-1 || nums[i] != nums[i+1]) {
                List<Integer> self = new ArrayList<Integer>();
             	self.add(no);
 			    temp.add(self);
            }
            
            for (List<Integer> list: temp) {
                result.add(new ArrayList<Integer>(list));
            }
 		}     

 		List<Integer> empty = new ArrayList<Integer>(); 		
 		result.add(empty);
 		
 		return result;
    }
}