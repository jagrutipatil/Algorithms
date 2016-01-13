public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int a = nums.length - k;
        if (nums.length == 1 || k < 0) {
            return;
        } 

        reverse(nums, 0 , a -1);           
        reverse(nums, a , nums.length-1);
        reverse(nums, 0 , nums.length-1);          
    }

    void reverse(int[] nums, int l, int r) {
        int t;
        while (l < r) {
             t = nums[r];
             nums[r] = nums[l];
             nums[l] = t;
             l++;
             r--;
        }
    }
}