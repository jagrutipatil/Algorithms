public class Solution {
    public List<Integer> countSmaller(int[] nums) {
          NumberIndex[] numbers = new NumberIndex[nums.length];

          for (int i = 0; i < nums.length; i++) {
               numbers[i] = new NumberIndex(nums[i], i);
          }

          int[] smallers = new int[nums.length];
          sort(numbers, smallers);

          List<Integer> result = new ArrayList<Integer>();
          for (int no : smallers) {
               result.add(no);
          }

          return result;
    }

    NumberIndex[] sort(NumberIndex[] nums, int[] smallers) {
        int mid = nums.length/2;

        if (mid > 0) {
            NumberIndex[] left = new NumberIndex[mid];
            NumberIndex[] right = new NumberIndex[nums.length - mid];
            int i = 0, j = 0;
            for (i = 0; i < mid; i++) {
                left[i] = nums[i];
            }

            for (i = 0; i < nums.length - mid; i++) {
                right[i] = nums[i+mid];
            }

            NumberIndex[] leftPart = sort(left, smallers);
            NumberIndex[] rightPart = sort(right, smallers);
            i = 0; j = 0;

            while (i < leftPart.length || j < rightPart.length) {
                if ( j == rightPart.length || i < leftPart.length && leftPart[i].no <= rightPart[j].no) {
                    nums[i+j] = leftPart[i];
                    smallers[leftPart[i].index] += j;
                    i++;
                } else {
                    nums[i+j] = rightPart[j];
                    j++;
                }
            }

        }
        return nums;
    }

    class NumberIndex{
        int no;
        int index;

        NumberIndex(int no, int index) {
            this.no = no;
            this.index = index;
        }

        NumberIndex(NumberIndex nmb) {
            this.no = nmb.no;
            this.index = nmb.index;
        }
    }
}