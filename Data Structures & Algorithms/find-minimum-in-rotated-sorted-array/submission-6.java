class Solution {
    public int findMin(int[] nums) {
         /*
         * In this problem, we have array sorted, but it's rotated one or two or n times.
         * So, we need to find min number sorted rotated array.
         */

        /*
         * Below two are edge cases
         */

        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        /*
         * We have sorted array but it's rotated.
         * For example sorted array = [1,2,3,4,5,6]
           if rotated 4 times, array= [3,4,5,6,1,2]

         * Here midpoint value is 5. i.e index 2.
         * To get a min element, we need to find unsorted side from midpoint.
         * In the above example, right of mid is unsorted i.e. 6,1,2 is unsorted.
         * why because in ascending order 1st element is always less than next element.
         * here first element is 3 which is less than mid 5.
         * on right side which is 6 is greater than 5 which means not ascending order. we need to move this window.
         * so, remove sorted window and adjust left to unsorted window.
         *
         */

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int midPoint = l + (r - l) / 2;

            // In first check we need to check midpoint is not out of bound like -1. We don;t have -ve indexes
            // AND we need to check current midpoint value is less than previous one and then that's the min value
            if (midPoint > 0 && nums[midPoint] < nums[midPoint - 1]) {
                return nums[midPoint];
            }
            /*
            In second check, we need to find unsorted window.
            Ascending order means, 1st element must be less than next element.
            Here we have two windows.
            window 1: left to midpoint
            window 2: midpoint  to right
            to check sorted window: For window 1, check first element <= last element i.e., midpoint
            And in window 2, check it is Unsorted or not: check midpoint that is start is greater than last element which is opposite to ascending order

            Then adjust window boundaries
             */
            else if (nums[midPoint] >= nums[l] && nums[midPoint] > nums[r]) {
                l = midPoint + 1;
            } else {
                r = midPoint;
            }

        }
        return nums[l];
    }
}
