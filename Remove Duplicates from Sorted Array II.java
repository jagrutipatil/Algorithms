/*
Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

Logic: Keep two indices prevIndex and currentIndex, and keep counter for how many times each number occurred. 
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int count = 1, prevIndex = 0, currentIndex = 0, prev = 0;
        if (nums.length == 0)
            return 0;

        while (currentIndex < nums.length) {
            int no = nums[currentIndex];
            if (count == 0 || (no == prev && count == 1)) {
                nums[prevIndex] = nums[currentIndex];
                prevIndex++;
                count++;
                prev = no;
            } else if (no != prev) {
                nums[prevIndex] = nums[currentIndex];
                prevIndex++;
                count = 1;              
                prev = no;
            }
            currentIndex++;
        }
        return prevIndex;
    }
}