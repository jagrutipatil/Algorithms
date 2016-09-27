/*
    Summary Ranges
    
    Given a sorted integer array without duplicates, return the summary of its ranges.

    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();


        int i = 0;
        while (i < nums.length) {
            start = nums[i];
            end = nums[i];
            i++;
            while (i < nums.length && end+1==nums[i]) {
                end = end+1;
                i++;
            }

            if (start != end) {
                result.add(start + "->" + end);
            } else {
                result.add(end);
            }
        }       

        return result;
    }
}