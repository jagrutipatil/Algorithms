/*
	Sort Colors

	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Notice:
	You are not suppose to use the library's sort function for this problem. You should do it in-place (sort numbers in the original array).

	Example
	Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
	
	Logic: 
	he solution requires the use of tracking 3 positions, the Low, Mid and High.

	We assume that the mid is the "Unknown" area that we must evaluate.

	If we encounter a 0, we know that it will be on the low end of the array, and if we encounter a 2, we know it will be on the high end of the array.

	To achieve this in one pass without preprocessing (counting), we simply traverse the unknown will generating the low and high ends.

	Take this example:

	Assume our input is: 1 0 2 2 1 0 (short for simplicity).

	Running the algorithm by hand would look something like:

	1 0 2 2 1 0
    ^         ^
    L         H
    M

    Mid != 0 || 2
    Mid++

    1 0 2 2 1 0
    ^ ^       ^
    L M       H

    Mid == 0
    Swap Low and Mid
    Mid++
    Low++

    0 1 2 2 1 0
      ^ ^     ^
      L M     H

    Mid == 2
    Swap High and Mid
    High--

    0 1 0 2 1 2
      ^ ^   ^
      L M   H

    Mid == 0
    Swap Low and Mid
    Mid++
    Low++

    0 0 1 2 1 2
        ^ ^ ^
        L M H

    Mid == 2
    Swap High and Mid
    High--

    0 0 1 1 2 2
        ^ ^
        L M
          H

    Mid <= High is our exit case

*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length -1;

        while (mid <= high) {        	
        	if (nums[mid]== 0) {
        		swap(nums, low, mid);
        		mid++;
        		low++;
        	} else if (nums[mid] == 1) {
        	    mid++;
        	} else if (nums[mid] == 2) {
        		swap(nums, mid, high);
        		high--;
        	}
        }
    }

    private void swap(int[] nums, int i, int j) {
    	  	int temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
    }
}


_________________________________________
//hardcoded approach

public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, c0 = 0, c1 = 0, c2 = 0, k = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 0) 
                c0++;
            if (nums[i] == 1) 
                c1++;
            if (nums[i] == 2) 
                c2++;    
        }
        
        while (c0!=0) {
            nums[k] = 0;
            c0--;
            k++;
        }       

        while (c1!=0) {
            nums[k] = 1;
            c1--;
            k++;
        }

        while (c2!=0) {
            nums[k] = 2;
            c2--;
            k++;
        }
    }
}