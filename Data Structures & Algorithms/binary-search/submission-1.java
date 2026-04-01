class Solution {
    public int search(int[] nums, int target) {
    /*
         * We can use Binary search on only sorted arrays.
         * In Binary search, we will divide array index to middle and will check our target by index
         *
         * We will have left of array index  and right index of array and middle index  of array.
         *
         * If our target greater than middle index value, we will update right index value to middle-1.
         * Why because array is sorted, right have highest values.
         *
         * If our target is less than middle, we will update left to middle +1;
         * why because array is sorted and on left we have lower values
         *
         * To calculate middle, we use
         1.  left+right/2 or
         2. left+ (right-left)/2
          2nd one is best. the second solution is to avoid potential arithmetic overflow
          the way i think of the second solution is left is your starting point, and (right - left) // 2 calculates half the distance between left and right.
          so your starting point + half the distance will naturally arrive in the middle of the two points, the midpoint.
          I don't think it matters in python, but it would in other languages with fixed sized numeric types.
         *
         */

        if (nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
        
    }
}
