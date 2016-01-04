public class Solution {
    public void nextPermutation(int[] nums) {
        if (!isNextPermutation(nums)) {
            Arrays.sort(nums);    
        }
    }

    boolean isNextPermutation(int[] nums) {
        int n = nums.length, desc = 0;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                desc = i;
                break;
            }
        }    

        if (desc == 0) 
            return false;
        
        for (int i = n-1; i >= desc; i--) {
            if (nums[i] > nums[desc-1]) {
                swap(nums, i, desc-1);
                break;
            }
        }
        reverse(nums, desc, n-1);
        return true;
    }

    void swap(int[] nums, int i , int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void reverse(int[] nums, int i, int j) {
        for ( ;i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}