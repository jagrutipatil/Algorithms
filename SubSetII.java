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

// By incrementing order

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        
        for (int i = 0; i < S.size(); i++) {
            if (i == 0 || S.get(i) != S.get(i-1)) {
                temp = new ArrayList<ArrayList<Integer>>();
                for (ArrayList<Integer> list : result) {
                    temp.add(new ArrayList<Integer>(list));
                }
            }

            for (ArrayList<Integer> list: temp) {
                list.add(S.get(i));
            }

            if (i == 0 || S.get(i) != S.get(i-1)) {
                ArrayList<Integer> self = new ArrayList<Integer>();
                self.add(S.get(i));
                temp.add(self);
            }

            for (ArrayList<Integer> list: temp) {
                result.add(new ArrayList<Integer>(list));
            }
        }
        ArrayList<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        
        return result;
    }
}
